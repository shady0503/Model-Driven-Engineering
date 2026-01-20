package com.mde.cli;

import ModelDrivenEngineering.BackendConfig;
import com.mde.generator.egl.EGLTemplateEngine;
import com.mde.generator.etl.ETLTransformationEngine;
import com.mde.loader.FlexmiModelLoader;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*") // Allow React app to call this
public class ProjectGenerationController {

    private final FlexmiModelLoader loader = new FlexmiModelLoader();

    @PostMapping("/generate")
    public ResponseEntity<ByteArrayResource> generateProject(@RequestBody String yamlContent) {
        try {
            // 1. Create temporary directory
            Path tempDir = Files.createTempDirectory("mde-gen-");
            Path outputDir = tempDir.resolve("output");

            // 2. Save YAML to temp file
            Path yamlFile = tempDir.resolve("model.yaml");
            // Ensure BackendConfig root if missing (simple heuristic for raw YAML)
            if (!yamlContent.trim().startsWith("BackendConfig:")) {
                yamlContent = "BackendConfig:\n" + yamlContent;
            }
            Files.write(yamlFile, yamlContent.getBytes(StandardCharsets.UTF_8));

            // Load Model (for filename)
            BackendConfig model = loader.load(yamlFile);

            // 3. Run Pipeline
            // We actually need to run the full pipeline: YAML -> BackendConfig -> ETL ->
            // Context -> EGL
            // The simplest way is to reuse the logic from GenerateCommand, or just invoke
            // engines directly.

            // A. Run ETL (PIM -> PSM)
            ETLTransformationEngine etlEngine = new ETLTransformationEngine();
            Path backendModelPath = yamlFile; // Flexmi can load from YAML file directly via ETL if configured,
                                              // but ETLTransformationEngine expects an EMF resource or Path.
                                              // Let's use the executeTransformation(Path input, Path output) overload.

            Path contextModelPath = tempDir.resolve("context.xmi");
            etlEngine.executeTransformation(backendModelPath, contextModelPath);

            // B. Run EGL (PSM -> Code)
            EGLTemplateEngine eglEngine = new EGLTemplateEngine(outputDir);
            eglEngine.generateProject(contextModelPath);

            // 5. Zip output
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (ZipOutputStream zos = new ZipOutputStream(baos)) {
                Files.walkFileTree(outputDir, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        String relativePath = outputDir.relativize(file).toString().replace("\\", "/");
                        zos.putNextEntry(new ZipEntry(relativePath));
                        Files.copy(file, zos);
                        zos.closeEntry();
                        return FileVisitResult.CONTINUE;
                    }
                });
            }

            // 6. Cleanup
            // (In production, use a background job/try-finally block to ensure deep delete)
            // For now, OS temp cleaner will handle eventually, or we accept minor leak for
            // prototype speed

            // 7. Return Zip
            ByteArrayResource resource = new ByteArrayResource(baos.toByteArray());
            String filename = model.getProject().getName() + ".zip";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(resource.contentLength())
                    .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
