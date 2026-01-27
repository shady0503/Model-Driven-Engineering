package com.codeforge.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.codeforge.loader.FlexmiModelLoaderWithValidation;
import com.codeforge.validation.ValidationResult;
import com.codeforge.validation.ValidationResult.Severity;

import Forge.BackendConfig;
import Forge.Database;
import picocli.CommandLine;

class ValidateCommandTest {

    private FlexmiModelLoaderWithValidation mockLoader;
    private ValidateCommand validateCommand;
    private CommandLine commandLine;

    @BeforeEach
    void setUp() {
        mockLoader = mock(FlexmiModelLoaderWithValidation.class);
        validateCommand = new TestableValidateCommand(mockLoader);
        ForgeCli parent = new ForgeCli();

        // Inject parent via reflection
        try {
            java.lang.reflect.Field parentField = ValidateCommand.class.getDeclaredField("parent");
            parentField.setAccessible(true);
            parentField.set(validateCommand, parent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        commandLine = new CommandLine(validateCommand);
    }

    @Test
    void testValidateSuccessful(@TempDir Path tempDir) throws Exception {
        File valFile = tempDir.resolve("model.yaml").toFile();
        valFile.createNewFile();

        BackendConfig mockConfig = mock(BackendConfig.class);
        Database mockDatabase = mock(Database.class);
        when(mockConfig.getDatabase()).thenReturn(mockDatabase);

        // Mock EList return
        EList mockTables = mock(EList.class);
        when(mockDatabase.getTables()).thenReturn(mockTables);

        when(mockLoader.load(any(Path.class))).thenReturn(mockConfig);
        when(mockLoader.validate(mockConfig)).thenReturn(Collections.emptyList());

        int exitCode = commandLine.execute(valFile.getAbsolutePath());

        assertEquals(0, exitCode);
        verify(mockLoader).load(valFile.toPath().toAbsolutePath());
        verify(mockLoader).validate(mockConfig);
    }

    @Test
    void testValidateFileNotFound() {
        int exitCode = commandLine.execute("non-existent-file.yaml");
        assertEquals(CommandLine.ExitCode.SOFTWARE, exitCode); // Default error code
    }

    @Test
    void testValidateWithErrors(@TempDir Path tempDir) throws Exception {
        File valFile = tempDir.resolve("model.yaml").toFile();
        valFile.createNewFile();

        BackendConfig mockConfig = mock(BackendConfig.class);
        when(mockLoader.load(any(Path.class))).thenReturn(mockConfig);

        ValidationResult error = new ValidationResult(Severity.ERROR, "Some error", "Location", "MockValidator");
        when(mockLoader.validate(mockConfig)).thenReturn(List.of(error));

        int exitCode = commandLine.execute(valFile.getAbsolutePath());

        assertEquals(ExitCode.VALIDATION_ERROR, exitCode);
    }

    @Test
    void testValidateWithWarningsStrict(@TempDir Path tempDir) throws Exception {
        File valFile = tempDir.resolve("model.yaml").toFile();
        valFile.createNewFile();

        BackendConfig mockConfig = mock(BackendConfig.class);
        when(mockLoader.load(any(Path.class))).thenReturn(mockConfig);

        ValidationResult warning = new ValidationResult(Severity.WARNING, "Some warning", "Location", "MockValidator");
        when(mockLoader.validate(mockConfig)).thenReturn(List.of(warning));

        int exitCode = commandLine.execute(valFile.getAbsolutePath(), "--strict");

        assertEquals(ExitCode.VALIDATION_ERROR, exitCode);
    }

    @Test
    void testValidateWithWarningsNotStrict(@TempDir Path tempDir) throws Exception {
        File valFile = tempDir.resolve("model.yaml").toFile();
        valFile.createNewFile();

        BackendConfig mockConfig = mock(BackendConfig.class);
        when(mockConfig.getDatabase()).thenReturn(mock(Database.class));
        when(mockLoader.load(any(Path.class))).thenReturn(mockConfig);

        ValidationResult warning = new ValidationResult(Severity.WARNING, "Some warning", "Location", "MockValidator");
        when(mockLoader.validate(mockConfig)).thenReturn(List.of(warning));

        int exitCode = commandLine.execute(valFile.getAbsolutePath());

        assertEquals(ExitCode.SUCCESS, exitCode);
    }

    // Subclass to inject mock
    static class TestableValidateCommand extends ValidateCommand {
        private final FlexmiModelLoaderWithValidation loader;

        TestableValidateCommand(FlexmiModelLoaderWithValidation loader) {
            this.loader = loader;
        }

        @Override
        protected FlexmiModelLoaderWithValidation createLoader() {
            return loader;
        }
    }
}
