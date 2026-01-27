package com.codeforge.generator.evl;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;

import Forge.BackendConfig;
import Forge.ForgePackage;
import com.codeforge.validation.ValidationResult;

/**
 * EVL Validation Engine
 * 
 * Executes OCL-based constraints defined in EVL files to validate models.
 */
public class EVLValidationEngine {

    private static final String EVL_SCRIPT_RESOURCE = "/evl/SpringConstraints.evl";

    public List<ValidationResult> validate(BackendConfig backendConfig) throws Exception {
        initializeEMF();
        EvlModule evlModule = new EvlModule();

        try {
            File evlFile = loadResourceAsFile(EVL_SCRIPT_RESOURCE);
            evlModule.parse(evlFile);

            EmfModel model = createModelFromObject(backendConfig);
            evlModule.getContext().getModelRepository().addModel(model);

            evlModule.execute();

            Collection<UnsatisfiedConstraint> unsatisfied = evlModule.getContext().getUnsatisfiedConstraints();
            List<ValidationResult> results = new ArrayList<>();

            for (UnsatisfiedConstraint constraint : unsatisfied) {
                results.add(ValidationResult.error(
                        constraint.getMessage(),
                        constraint.getInstance().toString(),
                        "EVL: " + constraint.getConstraint().getName()));
            }

            return results;

        } finally {
            evlModule.getContext().getModelRepository().dispose();
        }
    }

    private void initializeEMF() {
        EPackage.Registry.INSTANCE.put(ForgePackage.eNS_URI, ForgePackage.eINSTANCE);
    }

    private EmfModel createModelFromObject(BackendConfig backendConfig) throws EolModelLoadingException {
        Resource resource = backendConfig.eResource();
        EmfModel model = new EmfModel();
        model.setName("Forge");
        model.setResource(resource);
        model.setMetamodelFile(new File("model/Forge.ecore").getAbsolutePath());
        model.setReadOnLoad(false);
        model.setStoredOnDisposal(false);
        return model;
    }

    private File loadResourceAsFile(String resourcePath) throws Exception {
        InputStream resourceStream = getClass().getResourceAsStream(resourcePath);
        if (resourceStream == null) {
            throw new IllegalStateException("Resource not found in classpath: " + resourcePath);
        }
        String extension = resourcePath.substring(resourcePath.lastIndexOf('.'));
        Path tempFile = Files.createTempFile("Forge-evl-", extension);
        Files.copy(resourceStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        resourceStream.close();
        tempFile.toFile().deleteOnExit();
        return tempFile.toFile();
    }
}
