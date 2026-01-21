package com.mde.generator.Context;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import Context.ContextFactory;
import Context.ProjectContext;
import Context.EntityContext;
import Context.FieldContext;
import Context.RelationContext;
import Context.DependencyContext;

/**
 * Unit tests for Context metamodel classes
 * Tests the EMF-generated Context model structure
 */
public class ContextModelTest {

    private ContextFactory factory;

    @BeforeEach
    public void setUp() {
        factory = ContextFactory.eINSTANCE;
    }

    @Test
    public void testProjectContextCreation() {
        // Test creating a ProjectContext instance
        ProjectContext project = factory.createProjectContext();
        
        assertNotNull(project, "ProjectContext should be created");
        
        // Test setters and getters
        project.setGroupId("com.example");
        project.setArtifactId("test-app");
        project.setVersion("1.0.0");
        project.setPackageName("com.example.testapp");
        project.setJavaVersion("17");
        project.setSpringBootVersion("3.2.0");
        project.setDatabaseType("postgresql");
        project.setDatabaseName("testdb");
        
        assertEquals("com.example", project.getGroupId());
        assertEquals("test-app", project.getArtifactId());
        assertEquals("1.0.0", project.getVersion());
        assertEquals("com.example.testapp", project.getPackageName());
        assertEquals("17", project.getJavaVersion());
        assertEquals("3.2.0", project.getSpringBootVersion());
        assertEquals("postgresql", project.getDatabaseType());
        assertEquals("testdb", project.getDatabaseName());
    }

    @Test
    public void testEntityContextCreation() {
        EntityContext entity = factory.createEntityContext();
        
        assertNotNull(entity, "EntityContext should be created");
        
        entity.setTableName("users");
        entity.setClassName("User");
        entity.setPackageName("com.example.entity");
        entity.setHasRelationships(true);
        
        assertEquals("users", entity.getTableName());
        assertEquals("User", entity.getClassName());
        assertEquals("com.example.entity", entity.getPackageName());
        assertTrue(entity.isHasRelationships());
    }

    @Test
    public void testFieldContextCreation() {
        FieldContext field = factory.createFieldContext();
        
        assertNotNull(field, "FieldContext should be created");
        
        field.setColumnName("user_id");
        field.setFieldName("userId");
        field.setJavaType("Long");
        field.setIsPrimaryKey(true);
        field.setIsNullable(false);
        field.setIsUnique(true);
        
        assertEquals("user_id", field.getColumnName());
        assertEquals("userId", field.getFieldName());
        assertEquals("Long", field.getJavaType());
        assertTrue(field.isIsPrimaryKey());
        assertFalse(field.isIsNullable());
        assertTrue(field.isIsUnique());
    }

    @Test
    public void testRelationContextCreation() {
        RelationContext relation = factory.createRelationContext();
        
        assertNotNull(relation, "RelationContext should be created");
        
        relation.setFieldName("posts");
        relation.setTargetEntity("Post");
        relation.setRelationType("@OneToMany");
        relation.setIsOwner(false);
        relation.setJoinColumnName(null);
        relation.setMappedBy("author");
        relation.setCascadeType("ALL");
        relation.setFetchType("LAZY");
        
        assertEquals("posts", relation.getFieldName());
        assertEquals("Post", relation.getTargetEntity());
        assertEquals("@OneToMany", relation.getRelationType());
        assertFalse(relation.isIsOwner());
        assertNull(relation.getJoinColumnName());
        assertEquals("author", relation.getMappedBy());
        assertEquals("ALL", relation.getCascadeType());
        assertEquals("LAZY", relation.getFetchType());
    }

    @Test
    public void testDependencyContextCreation() {
        DependencyContext dependency = factory.createDependencyContext();
        
        assertNotNull(dependency, "DependencyContext should be created");
        
        dependency.setGroupId("org.springframework.boot");
        dependency.setArtifactId("spring-boot-starter-security");
        dependency.setVersion("3.2.0");
        dependency.setScope("compile");
        
        assertEquals("org.springframework.boot", dependency.getGroupId());
        assertEquals("spring-boot-starter-security", dependency.getArtifactId());
        assertEquals("3.2.0", dependency.getVersion());
        assertEquals("compile", dependency.getScope());
    }

    @Test
    public void testProjectContextWithEntities() {
        // Create a complete project structure
        ProjectContext project = factory.createProjectContext();
        project.setGroupId("com.example");
        project.setArtifactId("blog-api");
        
        // Create entity
        EntityContext userEntity = factory.createEntityContext();
        userEntity.setTableName("users");
        userEntity.setClassName("User");
        userEntity.setPackageName("com.example.blog.entity");
        userEntity.setHasRelationships(false);
        
        // Add entity to project
        project.getEntities().add(userEntity);
        
        assertEquals(1, project.getEntities().size());
        assertEquals("User", project.getEntities().get(0).getClassName());
    }

    @Test
    public void testEntityContextWithFields() {
        EntityContext entity = factory.createEntityContext();
        entity.setTableName("users");
        entity.setClassName("User");
        
        // Create primary key field
        FieldContext idField = factory.createFieldContext();
        idField.setColumnName("id");
        idField.setFieldName("id");
        idField.setJavaType("Long");
        idField.setIsPrimaryKey(true);
        idField.setIsNullable(false);
        idField.setIsUnique(true);
        
        // Create name field
        FieldContext nameField = factory.createFieldContext();
        nameField.setColumnName("name");
        nameField.setFieldName("name");
        nameField.setJavaType("String");
        nameField.setIsPrimaryKey(false);
        nameField.setIsNullable(false);
        nameField.setIsUnique(false);
        
        // Add fields to entity
        entity.getFields().add(idField);
        entity.getFields().add(nameField);
        entity.setPrimaryKey(idField);
        
        assertEquals(2, entity.getFields().size());
        assertNotNull(entity.getPrimaryKey());
        assertEquals("id", entity.getPrimaryKey().getFieldName());
        assertTrue(entity.getPrimaryKey().isIsPrimaryKey());
    }

    @Test
    public void testEntityContextWithRelations() {
        EntityContext userEntity = factory.createEntityContext();
        userEntity.setTableName("users");
        userEntity.setClassName("User");
        userEntity.setHasRelationships(true);
        
        // Create OneToMany relationship
        RelationContext postsRelation = factory.createRelationContext();
        postsRelation.setFieldName("posts");
        postsRelation.setTargetEntity("Post");
        postsRelation.setRelationType("@OneToMany");
        postsRelation.setIsOwner(false);
        postsRelation.setMappedBy("author");
        postsRelation.setCascadeType("ALL");
        postsRelation.setFetchType("LAZY");
        
        userEntity.getRelations().add(postsRelation);
        
        assertEquals(1, userEntity.getRelations().size());
        assertEquals("posts", userEntity.getRelations().get(0).getFieldName());
        assertTrue(userEntity.isHasRelationships());
    }

    @Test
    public void testProjectContextWithDependencies() {
        ProjectContext project = factory.createProjectContext();
        project.setArtifactId("test-project");
        
        // Add custom dependency
        DependencyContext securityDep = factory.createDependencyContext();
        securityDep.setGroupId("org.springframework.boot");
        securityDep.setArtifactId("spring-boot-starter-security");
        securityDep.setVersion("3.2.0");
        
        DependencyContext validationDep = factory.createDependencyContext();
        validationDep.setGroupId("org.springframework.boot");
        validationDep.setArtifactId("spring-boot-starter-validation");
        
        project.getDependencies().add(securityDep);
        project.getDependencies().add(validationDep);
        
        assertEquals(2, project.getDependencies().size());
        assertEquals("spring-boot-starter-security", project.getDependencies().get(0).getArtifactId());
    }

    @Test
    public void testCompleteProjectModel() {
        // Build a complete project model
        ProjectContext project = factory.createProjectContext();
        project.setGroupId("com.example");
        project.setArtifactId("blog-platform");
        project.setVersion("1.0.0");
        project.setPackageName("com.example.blog");
        project.setJavaVersion("17");
        project.setSpringBootVersion("3.2.0");
        project.setDatabaseType("postgresql");
        project.setDatabaseName("blogdb");
        
        // Create User entity
        EntityContext userEntity = factory.createEntityContext();
        userEntity.setTableName("users");
        userEntity.setClassName("User");
        userEntity.setPackageName("com.example.blog.entity");
        userEntity.setHasRelationships(true);
        
        // User ID field
        FieldContext userId = factory.createFieldContext();
        userId.setColumnName("id");
        userId.setFieldName("id");
        userId.setJavaType("Long");
        userId.setIsPrimaryKey(true);
        userId.setIsNullable(false);
        userId.setIsUnique(true);
        
        userEntity.getFields().add(userId);
        userEntity.setPrimaryKey(userId);
        
        // Create Post entity
        EntityContext postEntity = factory.createEntityContext();
        postEntity.setTableName("posts");
        postEntity.setClassName("Post");
        postEntity.setPackageName("com.example.blog.entity");
        postEntity.setHasRelationships(true);
        
        // Post ID field
        FieldContext postId = factory.createFieldContext();
        postId.setColumnName("id");
        postId.setFieldName("id");
        postId.setJavaType("Long");
        postId.setIsPrimaryKey(true);
        postId.setIsNullable(false);
        postId.setIsUnique(true);
        
        postEntity.getFields().add(postId);
        postEntity.setPrimaryKey(postId);
        
        // Add entities to project
        project.getEntities().add(userEntity);
        project.getEntities().add(postEntity);
        
        // Validate complete model
        assertNotNull(project);
        assertEquals(2, project.getEntities().size());
        assertEquals("blog-platform", project.getArtifactId());
        assertEquals("postgresql", project.getDatabaseType());
        
        // Validate entities
        EntityContext firstEntity = project.getEntities().get(0);
        assertNotNull(firstEntity.getPrimaryKey());
        assertEquals("User", firstEntity.getClassName());
        assertEquals(1, firstEntity.getFields().size());
    }

    @Test
    public void testFactorySingleton() {
        // Verify factory is a singleton
        ContextFactory factory1 = ContextFactory.eINSTANCE;
        ContextFactory factory2 = ContextFactory.eINSTANCE;
        
        assertSame(factory1, factory2, "Factory should be a singleton");
    }

    @Test
    public void testEmptyCollections() {
        ProjectContext project = factory.createProjectContext();
        EntityContext entity = factory.createEntityContext();
        
        // Collections should be initialized but empty
        assertNotNull(project.getEntities());
        assertNotNull(project.getDependencies());
        assertNotNull(entity.getFields());
        assertNotNull(entity.getRelations());
        
        assertEquals(0, project.getEntities().size());
        assertEquals(0, project.getDependencies().size());
        assertEquals(0, entity.getFields().size());
        assertEquals(0, entity.getRelations().size());
    }
}
