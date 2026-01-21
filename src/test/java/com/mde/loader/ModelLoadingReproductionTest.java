package com.mde.loader;

import ModelDrivenEngineering.BackendConfig;
import ModelDrivenEngineering.Relation;
import ModelDrivenEngineering.Table;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ModelLoadingReproductionTest {

    @TempDir
    Path tempDir;

    @Test
    void testLoadModelWithNewFields() throws Exception {
        String yamlContent = "?nsURI: http://www.ModelDrivenEngineering.com/model/v1\n" +
                "backendConfig:\n" +
                "  project:\n" +
                "    name: TestProject\n" +
                "    groupId: com.test\n" +
                "    version: \"1.2.3\"\n" +
                "    javaVersion: 17\n" +
                "    springBootVersion: \"3.2.0\"\n" +
                "    language: JAVA\n" +
                "    framework: SPRING_BOOT\n" +
                "  database:\n" +
                "    type: POSTGRE_SQL\n" +
                "    name: testdb\n" +
                "    host: localhost\n" +
                "    port: 5432\n" +
                "    tables:\n" +
                "      - name: User\n" +
                "        columns:\n" +
                "          - name: id\n" +
                "            type: LONG\n" +
                "            primary: true\n" +
                "      - name: Role\n" +
                "        columns:\n" +
                "          - name: id\n" +
                "            type: LONG\n" +
                "            primary: true\n" +
                "        relations:\n" +
                "          - targetTable: User\n" +
                "            type: MANY_TO_MANY\n" +
                "            joinTableName: user_roles\n" +
                "            joinColumnName: role_id\n" +
                "            inverseJoinColumnName: user_id\n" +
                "            mappedBy: roles\n";

        Path yamlFile = tempDir.resolve("mde.yaml");
        Files.writeString(yamlFile, yamlContent);

        FlexmiModelLoader loader = new FlexmiModelLoader();
        BackendConfig config = loader.load(yamlFile.toFile());

        assertNotNull(config);
        assertEquals("1.2.3", config.getProject().getVersion());

        Table roleTable = config.getDatabase().getTables().stream()
                .filter(t -> t.getName().equals("Role"))
                .findFirst()
                .orElseThrow();

        assertFalse(roleTable.getRelations().isEmpty());
        Relation relation = roleTable.getRelations().get(0);
        assertEquals("user_roles", relation.getJoinTableName());
        assertEquals("role_id", relation.getJoinColumnName());
        assertEquals("user_id", relation.getInverseJoinColumnName());
        assertEquals("roles", relation.getMappedBy());
    }
}
