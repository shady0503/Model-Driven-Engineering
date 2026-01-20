package com.mde.validation;

import ModelDrivenEngineering.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Comprehensive test suite for all validators
 */
class ModelValidationTest {
    
    private ModelDrivenEngineeringFactory factory;
    
    @BeforeEach
    void setUp() {
        factory = ModelDrivenEngineeringFactory.eINSTANCE;
    }
    
    // ==================== PrimaryKeyValidator Tests ====================
    
    @Test
    void testPrimaryKeyValidator_ValidTable() {
        BackendConfig config = createMinimalConfig();
        Table table = createTableWithPrimaryKey("users");
        config.getDatabase().getTables().add(table);
        
        PrimaryKeyValidator validator = new PrimaryKeyValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertTrue(results.isEmpty(), "Valid table should pass validation");
    }
    
    @Test
    void testPrimaryKeyValidator_NoPrimaryKey() {
        BackendConfig config = createMinimalConfig();
        Table table = factory.createTable();
        table.setName("users");
        Column col = factory.createColumn();
        col.setName("id");
        col.setType(DataType.INT);
        col.setPrimary(false);
        table.getColumns().add(col);
        config.getDatabase().getTables().add(table);
        
        PrimaryKeyValidator validator = new PrimaryKeyValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isError());
        assertTrue(results.get(0).getMessage().contains("no primary key"));
        assertTrue(results.get(0).getMessage().contains("users"));
    }
    
    // ==================== UniqueTableNamesValidator Tests ====================
    
    @Test
    void testUniqueTableNamesValidator_AllUnique() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        config.getDatabase().getTables().add(createTableWithPrimaryKey("posts"));
        config.getDatabase().getTables().add(createTableWithPrimaryKey("comments"));
        
        UniqueTableNamesValidator validator = new UniqueTableNamesValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertTrue(results.isEmpty(), "All unique table names should pass");
    }
    
    @Test
    void testUniqueTableNamesValidator_Duplicates() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        UniqueTableNamesValidator validator = new UniqueTableNamesValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isError());
        assertTrue(results.get(0).getMessage().contains("Duplicate table name"));
        assertTrue(results.get(0).getMessage().contains("users"));
    }
    
    // ==================== ForeignKeyTargetTableValidator Tests ====================
    
    @Test
    void testForeignKeyTargetTableValidator_ValidReference() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        Table posts = createTableWithPrimaryKey("posts");
        Column userIdCol = factory.createColumn();
        userIdCol.setName("user_id");
        userIdCol.setType(DataType.INT);
        Relation relation = factory.createRelation();
        relation.setTargetTable("users");
        relation.setTargetColumn("id");
        relation.setType(RelationType.MANY_TO_ONE);
        userIdCol.setRelation(relation);
        posts.getColumns().add(userIdCol);
        config.getDatabase().getTables().add(posts);
        
        ForeignKeyTargetTableValidator validator = new ForeignKeyTargetTableValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertTrue(results.isEmpty(), "Valid foreign key reference should pass");
    }
    
    @Test
    void testForeignKeyTargetTableValidator_NonExistentTable() {
        BackendConfig config = createMinimalConfig();
        
        Table posts = createTableWithPrimaryKey("posts");
        Column userIdCol = factory.createColumn();
        userIdCol.setName("user_id");
        userIdCol.setType(DataType.INT);
        Relation relation = factory.createRelation();
        relation.setTargetTable("non_existent_table");
        relation.setTargetColumn("id");
        userIdCol.setRelation(relation);
        posts.getColumns().add(userIdCol);
        config.getDatabase().getTables().add(posts);
        
        ForeignKeyTargetTableValidator validator = new ForeignKeyTargetTableValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isError());
        assertTrue(results.get(0).getMessage().contains("non-existent table"));
        assertTrue(results.get(0).getMessage().contains("non_existent_table"));
    }
    
    // ==================== ForeignKeyTargetColumnValidator Tests ====================
    
    @Test
    void testForeignKeyTargetColumnValidator_ValidReference() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        Table posts = createTableWithPrimaryKey("posts");
        Column userIdCol = factory.createColumn();
        userIdCol.setName("user_id");
        userIdCol.setType(DataType.INT);
        Relation relation = factory.createRelation();
        relation.setTargetTable("users");
        relation.setTargetColumn("id");
        relation.setType(RelationType.MANY_TO_ONE);
        userIdCol.setRelation(relation);
        posts.getColumns().add(userIdCol);
        config.getDatabase().getTables().add(posts);
        
        ForeignKeyTargetColumnValidator validator = new ForeignKeyTargetColumnValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertTrue(results.isEmpty(), "Valid column reference should pass");
    }
    
    @Test
    void testForeignKeyTargetColumnValidator_NonExistentColumn() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        Table posts = createTableWithPrimaryKey("posts");
        Column userIdCol = factory.createColumn();
        userIdCol.setName("user_id");
        userIdCol.setType(DataType.INT);
        Relation relation = factory.createRelation();
        relation.setTargetTable("users");
        relation.setTargetColumn("non_existent_column");
        userIdCol.setRelation(relation);
        posts.getColumns().add(userIdCol);
        config.getDatabase().getTables().add(posts);
        
        ForeignKeyTargetColumnValidator validator = new ForeignKeyTargetColumnValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isError());
        assertTrue(results.get(0).getMessage().contains("non-existent column"));
        assertTrue(results.get(0).getMessage().contains("non_existent_column"));
    }
    
    // ==================== ForeignKeyTypeCompatibilityValidator Tests ====================
    
    @Test
    void testForeignKeyTypeCompatibilityValidator_MatchingTypes() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        Table posts = createTableWithPrimaryKey("posts");
        Column userIdCol = factory.createColumn();
        userIdCol.setName("user_id");
        userIdCol.setType(DataType.INT); // Same type as users.id
        Relation relation = factory.createRelation();
        relation.setTargetTable("users");
        relation.setTargetColumn("id");
        userIdCol.setRelation(relation);
        posts.getColumns().add(userIdCol);
        config.getDatabase().getTables().add(posts);
        
        ForeignKeyTypeCompatibilityValidator validator = new ForeignKeyTypeCompatibilityValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertTrue(results.isEmpty(), "Matching types should pass");
    }
    
    @Test
    void testForeignKeyTypeCompatibilityValidator_TypeMismatch() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        Table posts = createTableWithPrimaryKey("posts");
        Column userIdCol = factory.createColumn();
        userIdCol.setName("user_id");
        userIdCol.setType(DataType.STRING); // Different type
        Relation relation = factory.createRelation();
        relation.setTargetTable("users");
        relation.setTargetColumn("id");
        userIdCol.setRelation(relation);
        posts.getColumns().add(userIdCol);
        config.getDatabase().getTables().add(posts);
        
        ForeignKeyTypeCompatibilityValidator validator = new ForeignKeyTypeCompatibilityValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isWarning());
        assertTrue(results.get(0).getMessage().contains("Type mismatch"));
    }
    
    // ==================== UniqueColumnNamesValidator Tests ====================
    
    @Test
    void testUniqueColumnNamesValidator_AllUnique() {
        BackendConfig config = createMinimalConfig();
        Table table = factory.createTable();
        table.setName("users");
        table.getColumns().add(createColumn("id", DataType.INT, true));
        table.getColumns().add(createColumn("username", DataType.STRING, false));
        table.getColumns().add(createColumn("email", DataType.STRING, false));
        config.getDatabase().getTables().add(table);
        
        UniqueColumnNamesValidator validator = new UniqueColumnNamesValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertTrue(results.isEmpty(), "All unique column names should pass");
    }
    
    @Test
    void testUniqueColumnNamesValidator_Duplicates() {
        BackendConfig config = createMinimalConfig();
        Table table = factory.createTable();
        table.setName("users");
        table.getColumns().add(createColumn("id", DataType.INT, true));
        table.getColumns().add(createColumn("name", DataType.STRING, false));
        table.getColumns().add(createColumn("name", DataType.STRING, false));
        config.getDatabase().getTables().add(table);
        
        UniqueColumnNamesValidator validator = new UniqueColumnNamesValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isError());
        assertTrue(results.get(0).getMessage().contains("Duplicate column name"));
        assertTrue(results.get(0).getMessage().contains("name"));
    }
    
    // ==================== ApiRouteEntityValidator Tests ====================
    
    @Test
    void testApiRouteEntityValidator_ValidRoute() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        Api api = factory.createApi();
        api.setBasePath("/api");
        Route route = factory.createRoute();
        route.setEntity("users");
        route.getMethods().add(HttpMethod.CREATE);
        api.getRoutes().add(route);
        config.setApi(api);
        
        ApiRouteEntityValidator validator = new ApiRouteEntityValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertTrue(results.isEmpty(), "Valid route should pass");
    }
    
    @Test
    void testApiRouteEntityValidator_NonExistentEntity() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        Api api = factory.createApi();
        api.setBasePath("/api");
        Route route = factory.createRoute();
        route.setEntity("non_existent_entity");
        route.getMethods().add(HttpMethod.CREATE);
        api.getRoutes().add(route);
        config.setApi(api);
        
        ApiRouteEntityValidator validator = new ApiRouteEntityValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isError());
        assertTrue(results.get(0).getMessage().contains("non-existent entity"));
        assertTrue(results.get(0).getMessage().contains("non_existent_entity"));
    }
    
    // ==================== JavaReservedKeywordValidator Tests ====================
    
    @Test
    void testJavaReservedKeywordValidator_ValidNames() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        JavaReservedKeywordValidator validator = new JavaReservedKeywordValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertTrue(results.isEmpty(), "Valid names should pass");
    }
    
    @Test
    void testJavaReservedKeywordValidator_TableWithKeyword() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("class"));
        
        JavaReservedKeywordValidator validator = new JavaReservedKeywordValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isError());
        assertTrue(results.get(0).getMessage().contains("Java reserved keyword"));
        assertTrue(results.get(0).getMessage().contains("class"));
    }
    
    @Test
    void testJavaReservedKeywordValidator_ColumnWithKeyword() {
        BackendConfig config = createMinimalConfig();
        Table table = factory.createTable();
        table.setName("users");
        table.getColumns().add(createColumn("id", DataType.INT, true));
        table.getColumns().add(createColumn("static", DataType.STRING, false));
        config.getDatabase().getTables().add(table);
        
        JavaReservedKeywordValidator validator = new JavaReservedKeywordValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isError());
        assertTrue(results.get(0).getMessage().contains("Java reserved keyword"));
        assertTrue(results.get(0).getMessage().contains("static"));
    }
    
    // ==================== SqlReservedKeywordValidator Tests ====================
    
    @Test
    void testSqlReservedKeywordValidator_ValidNames() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        SqlReservedKeywordValidator validator = new SqlReservedKeywordValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertTrue(results.isEmpty(), "Valid names should pass");
    }
    
    @Test
    void testSqlReservedKeywordValidator_TableWithKeyword() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("select"));
        
        SqlReservedKeywordValidator validator = new SqlReservedKeywordValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isWarning());
        assertTrue(results.get(0).getMessage().contains("SQL reserved keyword"));
        assertTrue(results.get(0).getMessage().contains("select"));
    }
    
    @Test
    void testSqlReservedKeywordValidator_ColumnWithKeyword() {
        BackendConfig config = createMinimalConfig();
        Table table = factory.createTable();
        table.setName("products");
        table.getColumns().add(createColumn("id", DataType.INT, true));
        table.getColumns().add(createColumn("order", DataType.INT, false));
        config.getDatabase().getTables().add(table);
        
        SqlReservedKeywordValidator validator = new SqlReservedKeywordValidator();
        List<ValidationResult> results = validator.validate(config);
        
        assertEquals(1, results.size());
        assertTrue(results.get(0).isWarning());
        assertTrue(results.get(0).getMessage().contains("SQL reserved keyword"));
        assertTrue(results.get(0).getMessage().contains("order"));
    }
    
    // ==================== ModelValidationEngine Tests ====================
    
    @Test
    void testValidationEngine_CreateDefault() {
        ModelValidationEngine engine = ModelValidationEngine.createDefault();
        
        assertNotNull(engine);
        assertEquals(9, engine.getValidatorCount(), "Should have 9 default validators");
    }
    
    @Test
    void testValidationEngine_ValidModel() {
        BackendConfig config = createMinimalConfig();
        config.getDatabase().getTables().add(createTableWithPrimaryKey("users"));
        
        ModelValidationEngine engine = ModelValidationEngine.createDefault();
        List<ValidationResult> results = engine.validate(config);
        
        assertTrue(results.isEmpty(), "Valid model should pass all validators");
        assertTrue(engine.isValid(config));
        assertFalse(engine.hasErrors(config));
    }
    
    @Test
    void testValidationEngine_InvalidModel() {
        BackendConfig config = createMinimalConfig();
        
        // Table with no primary key
        Table table = factory.createTable();
        table.setName("users");
        Column col = factory.createColumn();
        col.setName("id");
        col.setType(DataType.INT);
        col.setPrimary(false);
        table.getColumns().add(col);
        config.getDatabase().getTables().add(table);
        
        ModelValidationEngine engine = ModelValidationEngine.createDefault();
        List<ValidationResult> results = engine.validate(config);
        
        assertFalse(results.isEmpty());
        assertFalse(engine.isValid(config));
        assertTrue(engine.hasErrors(config));
    }
    
    @Test
    void testValidationEngine_FormatResults() {
        BackendConfig config = createMinimalConfig();
        Table table = factory.createTable();
        table.setName("users");
        Column col = factory.createColumn();
        col.setName("id");
        col.setType(DataType.INT);
        col.setPrimary(false);
        table.getColumns().add(col);
        config.getDatabase().getTables().add(table);
        
        ModelValidationEngine engine = ModelValidationEngine.createDefault();
        List<ValidationResult> results = engine.validate(config);
        
        String formatted = ModelValidationEngine.formatResults(results);
        
        assertNotNull(formatted);
        assertTrue(formatted.contains("error"));
        assertTrue(formatted.contains("no primary key"));
    }
    
    // ==================== Helper Methods ====================
    
    private BackendConfig createMinimalConfig() {
        BackendConfig config = factory.createBackendConfig();
        
        Project project = factory.createProject();
        project.setName("TestProject");
        project.setGroupId("com.test");
        project.setLanguage(Language.JAVA);
        project.setFramework(Framework.SPRING_BOOT);
        project.setJavaVersion(17);
        project.setSpringBootVersion("3.2.0");
        config.setProject(project);
        
        Database database = factory.createDatabase();
        database.setType(DatabaseType.POSTGRE_SQL);
        database.setName("testdb");
        database.setHost("localhost");
        database.setPort(5432);
        config.setDatabase(database);
        
        return config;
    }
    
    private Table createTableWithPrimaryKey(String tableName) {
        Table table = factory.createTable();
        table.setName(tableName);
        
        Column idCol = factory.createColumn();
        idCol.setName("id");
        idCol.setType(DataType.INT);
        idCol.setPrimary(true);
        idCol.setNullable(false);
        
        table.getColumns().add(idCol);
        return table;
    }
    
    private Column createColumn(String name, DataType type, boolean isPrimary) {
        Column col = factory.createColumn();
        col.setName(name);
        col.setType(type);
        col.setPrimary(isPrimary);
        return col;
    }
}
