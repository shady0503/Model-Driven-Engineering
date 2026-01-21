package com.mde.generator;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class ReproductionTest {
    @Test
    public void testReproduce() throws Exception {
        Path inputYaml = Paths.get("reproduce_issue.yaml");
        Path outputDir = Paths.get("output_repro");

        System.out.println("Starting reproduction test...");
        CodeGenerator generator = new CodeGenerator();
        generator.generateProject(inputYaml, outputDir);
        System.out.println("Reproduction test completed successfully (no crash).");
    }
}
