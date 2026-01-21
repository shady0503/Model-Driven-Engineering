package com.mde.generator.Context;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import Context.ContextFactory;
import Context.ProjectContext;
import Context.EntityContext;
import Context.FieldContext;
import Context.RelationContext;
import Context.DependencyContext;

/**
 * Integration tests for Context metamodel
 * Tests complex model interactions and relationships
 */
public class ContextModelIntegrationTest {

    private ContextFactory factory;

    @BeforeEach
    public void setUp() {
        factory = ContextFactory.eINSTANCE;
    }

    @Test
    @DisplayName("Should create a complete blog platform project model")
    public void testCompleteBlogPlatformModel() {
        // Create project
        ProjectContext project = createBlogProject();

        // Validate project structure
        assertEquals("com.example", project.getGroupId());
        assertEquals("blog-platform", project.getArtifactId());
        assertEquals("1.0.0", project.getVersion());
        assertEquals("com.example.blog", project.getPackageName());
        assertEquals("17", project.getJavaVersion());
        assertEquals("3.2.0", project.getSpringBootVersion());
        assertEquals("postgresql", project.getDatabaseType());
        assertEquals("blogdb", project.getDatabaseName());

        // Validate entities
        assertEquals(3, project.getEntities().size());

        // Validate User entity
        EntityContext userEntity = findEntityByClassName(project, "User");
        assertNotNull(userEntity);
        assertEquals("users", userEntity.getTableName());
        assertEquals(4, userEntity.getFields().size());
        assertEquals(1, userEntity.getRelations().size());
        assertTrue(userEntity.isHasRelationships());

        // Validate Post entity
        EntityContext postEntity = findEntityByClassName(project, "Post");
        assertNotNull(postEntity);
        assertEquals("posts", postEntity.getTableName());
        assertEquals(5, postEntity.getFields().size());
        assertEquals(2, postEntity.getRelations().size());
        assertTrue(postEntity.isHasRelationships());

        // Validate Comment entity
        EntityContext commentEntity = findEntityByClassName(project, "Comment");
        assertNotNull(commentEntity);
        assertEquals("comments", commentEntity.getTableName());
        assertEquals(4, commentEntity.getFields().size());
        assertEquals(2, commentEntity.getRelations().size());

        // Validate dependencies
        assertEquals(2, project.getDependencies().size());
    }

    @Test
    @DisplayName("Should correctly model entity relationships")
    public void testEntityRelationships() {
        ProjectContext project = createBlogProject();

        EntityContext userEntity = findEntityByClassName(project, "User");
        EntityContext postEntity = findEntityByClassName(project, "Post");

        // User has OneToMany relationship with Post
        RelationContext userPostsRelation = userEntity.getRelations().get(0);
        assertEquals("posts", userPostsRelation.getFieldName());
        assertEquals("Post", userPostsRelation.getTargetEntity());
        assertEquals("@OneToMany", userPostsRelation.getRelationType());
        assertFalse(userPostsRelation.isIsOwner());
        assertEquals("author", userPostsRelation.getMappedBy());
        assertEquals("ALL", userPostsRelation.getCascadeType());
        assertEquals("LAZY", userPostsRelation.getFetchType());

        // Post has ManyToOne relationship with User
        RelationContext postAuthorRelation = findRelationByFieldName(postEntity, "author");
        assertNotNull(postAuthorRelation);
        assertEquals("author", postAuthorRelation.getFieldName());
        assertEquals("User", postAuthorRelation.getTargetEntity());
        assertEquals("@ManyToOne", postAuthorRelation.getRelationType());
        assertTrue(postAuthorRelation.isIsOwner());
        assertEquals("user_id", postAuthorRelation.getJoinColumnName());
        assertNull(postAuthorRelation.getMappedBy());
    }

    @Test
    @DisplayName("Should correctly model primary keys and fields")
    public void testFieldMapping() {
        ProjectContext project = createBlogProject();
        EntityContext userEntity = findEntityByClassName(project, "User");

        // Validate primary key
        assertNotNull(userEntity.getPrimaryKey());
        assertEquals("id", userEntity.getPrimaryKey().getFieldName());
        assertEquals("Long", userEntity.getPrimaryKey().getJavaType());
        assertTrue(userEntity.getPrimaryKey().isIsPrimaryKey());
        assertFalse(userEntity.getPrimaryKey().isIsNullable());
        assertTrue(userEntity.getPrimaryKey().isIsUnique());

        // Validate email field (unique constraint)
        FieldContext emailField = findFieldByName(userEntity, "email");
        assertNotNull(emailField);
        assertEquals("email", emailField.getColumnName());
        assertEquals("email", emailField.getFieldName());
        assertEquals("String", emailField.getJavaType());
        assertFalse(emailField.isIsPrimaryKey());
        assertFalse(emailField.isIsNullable());
        assertTrue(emailField.isIsUnique());

        // Validate name field (no unique constraint)
        FieldContext nameField = findFieldByName(userEntity, "name");
        assertNotNull(nameField);
        assertFalse(nameField.isIsUnique());
    }

    @Test
    @DisplayName("Should handle bidirectional relationships correctly")
    public void testBidirectionalRelationships() {
        ProjectContext project = createBlogProject();

        EntityContext postEntity = findEntityByClassName(project, "Post");
        EntityContext commentEntity = findEntityByClassName(project, "Comment");

        // Post -> Comments (one-to-many, non-owning)
        RelationContext postCommentsRelation = findRelationByFieldName(postEntity, "comments");
        assertNotNull(postCommentsRelation);
        assertEquals("Comment", postCommentsRelation.getTargetEntity());
        assertEquals("@OneToMany", postCommentsRelation.getRelationType());
        assertFalse(postCommentsRelation.isIsOwner());
        assertEquals("post", postCommentsRelation.getMappedBy());

        // Comment -> Post (many-to-one, owning)
        RelationContext commentPostRelation = findRelationByFieldName(commentEntity, "post");
        assertNotNull(commentPostRelation);
        assertEquals("Post", commentPostRelation.getTargetEntity());
        assertEquals("@ManyToOne", commentPostRelation.getRelationType());
        assertTrue(commentPostRelation.isIsOwner());
        assertEquals("post_id", commentPostRelation.getJoinColumnName());
    }

    @Test
    @DisplayName("Should support different database types")
    public void testDatabaseTypeConfiguration() {
        // Test PostgreSQL
        ProjectContext postgresProject = factory.createProjectContext();
        postgresProject.setDatabaseType("postgresql");
        postgresProject.setDatabaseName("mydb");

        assertEquals("postgresql", postgresProject.getDatabaseType());
        assertEquals("mydb", postgresProject.getDatabaseName());

        // Test MySQL
        ProjectContext mysqlProject = factory.createProjectContext();
        mysqlProject.setDatabaseType("mysql");
        mysqlProject.setDatabaseName("testdb");

        assertEquals("mysql", mysqlProject.getDatabaseType());
        assertEquals("testdb", mysqlProject.getDatabaseName());
    }

    @Test
    @DisplayName("Should support custom dependencies")
    public void testCustomDependencies() {
        ProjectContext project = createBlogProject();

        DependencyContext securityDep = findDependencyByArtifactId(project, "spring-boot-starter-security");
        assertNotNull(securityDep);
        assertEquals("org.springframework.boot", securityDep.getGroupId());
        assertEquals("spring-boot-starter-security", securityDep.getArtifactId());
        assertEquals("3.2.0", securityDep.getVersion());
        assertEquals("compile", securityDep.getScope());

        DependencyContext validationDep = findDependencyByArtifactId(project, "spring-boot-starter-validation");
        assertNotNull(validationDep);
        assertNull(validationDep.getVersion()); // Uses parent version
    }

    @Test
    @DisplayName("Should support different Java types")
    public void testJavaTypeMapping() {
        EntityContext entity = factory.createEntityContext();

        FieldContext longField = createField("id", "id", "Long", true, false, true);
        FieldContext stringField = createField("name", "name", "String", false, false, false);
        FieldContext dateTimeField = createField("created_at", "createdAt", "LocalDateTime", false, false, false);
        FieldContext booleanField = createField("active", "active", "Boolean", false, true, false);

        entity.getFields().add(longField);
        entity.getFields().add(stringField);
        entity.getFields().add(dateTimeField);
        entity.getFields().add(booleanField);

        assertEquals(4, entity.getFields().size());
        assertEquals("Long", entity.getFields().get(0).getJavaType());
        assertEquals("String", entity.getFields().get(1).getJavaType());
        assertEquals("LocalDateTime", entity.getFields().get(2).getJavaType());
        assertEquals("Boolean", entity.getFields().get(3).getJavaType());
    }

    @Test
    @DisplayName("Should maintain entity package naming consistency")
    public void testPackageNamingConsistency() {
        ProjectContext project = createBlogProject();
        String basePackage = project.getPackageName();

        for (EntityContext entity : project.getEntities()) {
            assertTrue(entity.getPackageName().startsWith(basePackage),
                    "Entity package should start with base package: " + entity.getClassName());
            assertTrue(entity.getPackageName().endsWith(".entity"),
                    "Entity package should end with .entity: " + entity.getClassName());
        }
    }

    // Helper methods

    private ProjectContext createBlogProject() {
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
        EntityContext userEntity = createUserEntity();
        project.getEntities().add(userEntity);

        // Create Post entity
        EntityContext postEntity = createPostEntity();
        project.getEntities().add(postEntity);

        // Create Comment entity
        EntityContext commentEntity = createCommentEntity();
        project.getEntities().add(commentEntity);

        // Add dependencies
        DependencyContext securityDep = factory.createDependencyContext();
        securityDep.setGroupId("org.springframework.boot");
        securityDep.setArtifactId("spring-boot-starter-security");
        securityDep.setVersion("3.2.0");
        securityDep.setScope("compile");
        project.getDependencies().add(securityDep);

        DependencyContext validationDep = factory.createDependencyContext();
        validationDep.setGroupId("org.springframework.boot");
        validationDep.setArtifactId("spring-boot-starter-validation");
        project.getDependencies().add(validationDep);

        return project;
    }

    private EntityContext createUserEntity() {
        EntityContext entity = factory.createEntityContext();
        entity.setTableName("users");
        entity.setClassName("User");
        entity.setPackageName("com.example.blog.entity");
        entity.setHasRelationships(true);

        // Fields
        FieldContext id = createField("id", "id", "Long", true, false, true);
        FieldContext name = createField("name", "name", "String", false, false, false);
        FieldContext email = createField("email", "email", "String", false, false, true);
        FieldContext createdAt = createField("created_at", "createdAt", "LocalDateTime", false, false, false);

        entity.getFields().add(id);
        entity.getFields().add(name);
        entity.getFields().add(email);
        entity.getFields().add(createdAt);
        entity.setPrimaryKey(id);

        // Relationship: User -> Posts
        RelationContext postsRelation = factory.createRelationContext();
        postsRelation.setFieldName("posts");
        postsRelation.setTargetEntity("Post");
        postsRelation.setRelationType("@OneToMany");
        postsRelation.setIsOwner(false);
        postsRelation.setMappedBy("author");
        postsRelation.setCascadeType("ALL");
        postsRelation.setFetchType("LAZY");
        entity.getRelations().add(postsRelation);

        return entity;
    }

    private EntityContext createPostEntity() {
        EntityContext entity = factory.createEntityContext();
        entity.setTableName("posts");
        entity.setClassName("Post");
        entity.setPackageName("com.example.blog.entity");
        entity.setHasRelationships(true);

        // Fields
        FieldContext id = createField("id", "id", "Long", true, false, true);
        FieldContext title = createField("title", "title", "String", false, false, false);
        FieldContext content = createField("content", "content", "String", false, true, false);
        FieldContext published = createField("published", "published", "Boolean", false, false, false);
        FieldContext createdAt = createField("created_at", "createdAt", "LocalDateTime", false, false, false);

        entity.getFields().add(id);
        entity.getFields().add(title);
        entity.getFields().add(content);
        entity.getFields().add(published);
        entity.getFields().add(createdAt);
        entity.setPrimaryKey(id);

        // Relationship: Post -> User (author)
        RelationContext authorRelation = factory.createRelationContext();
        authorRelation.setFieldName("author");
        authorRelation.setTargetEntity("User");
        authorRelation.setRelationType("@ManyToOne");
        authorRelation.setIsOwner(true);
        authorRelation.setJoinColumnName("user_id");
        authorRelation.setCascadeType("NONE");
        authorRelation.setFetchType("EAGER");
        entity.getRelations().add(authorRelation);

        // Relationship: Post -> Comments
        RelationContext commentsRelation = factory.createRelationContext();
        commentsRelation.setFieldName("comments");
        commentsRelation.setTargetEntity("Comment");
        commentsRelation.setRelationType("@OneToMany");
        commentsRelation.setIsOwner(false);
        commentsRelation.setMappedBy("post");
        commentsRelation.setCascadeType("ALL");
        commentsRelation.setFetchType("LAZY");
        entity.getRelations().add(commentsRelation);

        return entity;
    }

    private EntityContext createCommentEntity() {
        EntityContext entity = factory.createEntityContext();
        entity.setTableName("comments");
        entity.setClassName("Comment");
        entity.setPackageName("com.example.blog.entity");
        entity.setHasRelationships(true);

        // Fields
        FieldContext id = createField("id", "id", "Long", true, false, true);
        FieldContext content = createField("content", "content", "String", false, false, false);
        FieldContext createdAt = createField("created_at", "createdAt", "LocalDateTime", false, false, false);
        FieldContext approved = createField("approved", "approved", "Boolean", false, false, false);

        entity.getFields().add(id);
        entity.getFields().add(content);
        entity.getFields().add(createdAt);
        entity.getFields().add(approved);
        entity.setPrimaryKey(id);

        // Relationship: Comment -> Post
        RelationContext postRelation = factory.createRelationContext();
        postRelation.setFieldName("post");
        postRelation.setTargetEntity("Post");
        postRelation.setRelationType("@ManyToOne");
        postRelation.setIsOwner(true);
        postRelation.setJoinColumnName("post_id");
        postRelation.setCascadeType("NONE");
        postRelation.setFetchType("LAZY");
        entity.getRelations().add(postRelation);

        // Relationship: Comment -> User (author)
        RelationContext authorRelation = factory.createRelationContext();
        authorRelation.setFieldName("author");
        authorRelation.setTargetEntity("User");
        authorRelation.setRelationType("@ManyToOne");
        authorRelation.setIsOwner(true);
        authorRelation.setJoinColumnName("user_id");
        authorRelation.setCascadeType("NONE");
        authorRelation.setFetchType("EAGER");
        entity.getRelations().add(authorRelation);

        return entity;
    }

    private FieldContext createField(String columnName, String fieldName, String javaType,
            boolean isPK, boolean isNullable, boolean isUnique) {
        FieldContext field = factory.createFieldContext();
        field.setColumnName(columnName);
        field.setFieldName(fieldName);
        field.setJavaType(javaType);
        field.setIsPrimaryKey(isPK);
        field.setIsNullable(isNullable);
        field.setIsUnique(isUnique);
        return field;
    }

    private EntityContext findEntityByClassName(ProjectContext project, String className) {
        return project.getEntities().stream()
                .filter(e -> e.getClassName().equals(className))
                .findFirst()
                .orElse(null);
    }

    private FieldContext findFieldByName(EntityContext entity, String fieldName) {
        return entity.getFields().stream()
                .filter(f -> f.getFieldName().equals(fieldName))
                .findFirst()
                .orElse(null);
    }

    private RelationContext findRelationByFieldName(EntityContext entity, String fieldName) {
        return entity.getRelations().stream()
                .filter(r -> r.getFieldName().equals(fieldName))
                .findFirst()
                .orElse(null);
    }

    private DependencyContext findDependencyByArtifactId(ProjectContext project, String artifactId) {
        return project.getDependencies().stream()
                .filter(d -> d.getArtifactId().equals(artifactId))
                .findFirst()
                .orElse(null);
    }
}
