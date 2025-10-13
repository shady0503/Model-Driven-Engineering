import com.mde.ModelDrivenEngineering.BackendConfig;
import com.mde.ModelDrivenEngineering.Database;
import com.mde.ModelDrivenEngineering.Project;
import com.mde.loader.FlexmiModelLoader;
import com.mde.loader.LoadException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlexmiModelLoaderTest {

    private FlexmiModelLoader loader;

    @BeforeEach
    void setUp() {
        // Create new loader before each test
        loader = new FlexmiModelLoader();
    }

    @Test
    void testLoadMinimalExample() throws LoadException {
        // Arrange
        String filePath = "examples/minimal-example.yaml";

        // Act
        BackendConfig config = loader.load(filePath);

        // Assert - Basic structure
        assertNotNull(config, "Config should not be null");

        // Assert - Project
        Project project = config.getProject();
        assertNotNull(project, "Project should not be null");
        assertEquals("MinimalBlog", project.getName());
        assertEquals("com.example", project.getGroupId());

        // Assert - Database
        Database database = config.getDatabase();
        assertNotNull(database, "Database should not be null");
        assertEquals("minimal_blog", database.getName());
        System.out.println(database.getName().toString());
        assertNotNull(database.getTables(), "Tables list should not be null");
        assertFalse(database.getTables().isEmpty(), "Should have at least one table");

        // Assert - Table
        assertEquals("users", database.getTables().get(0).getName());

        System.out.println("✓ Minimal example loaded successfully!");
    }

    @Test
    void testLoadBlogExample() throws LoadException {
        // Arrange
        String filePath = "examples/blog-example.yaml";

        // Act
        BackendConfig config = loader.load(filePath);

        // Assert
        assertNotNull(config);
        assertEquals("BlogPlatform", config.getProject().getName());

        // Check we have 3 tables
        assertEquals(3, config.getDatabase().getTables().size());

        // Check relationship exists
        var postsTable = config.getDatabase().getTables().get(1);
        assertEquals("posts", postsTable.getName());

        // Find user_id column
        var userIdColumn = postsTable.getColumns().stream()
                .filter(col -> "user_id".equals(col.getName()))
                .findFirst()
                .orElseThrow();

        // Check relation
        assertNotNull(userIdColumn.getRelation(), "user_id should have a relation");
        assertEquals("users", userIdColumn.getRelation().getTargetTable());
        assertEquals("id", userIdColumn.getRelation().getTargetColumn());

        System.out.println("✓ Blog example with relationships loaded successfully!");
    }

    @Test
    void testLoadNonExistentFile() {
        // Arrange
        String invalidPath = "does-not-exist.yaml";

        // Act & Assert
        LoadException exception = assertThrows(LoadException.class, () -> {
            loader.load(invalidPath);
        });

        // Verify error message is helpful
        assertTrue(exception.getMessage().contains("not found") ||
                exception.getMessage().contains("does-not-exist"));

        System.out.println("✓ Correctly handles missing file");
    }
    // Tests will be added next
}