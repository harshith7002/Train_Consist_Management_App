import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainServiceTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] ids = {};

        Exception ex = assertThrows(
                IllegalStateException.class,
                () -> TrainService.searchBogieWithValidation(ids, "BG101")
        );

        assertEquals("No bogies available for search", ex.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] ids = {"BG101", "BG205"};

        assertDoesNotThrow(() ->
                TrainService.searchBogieWithValidation(ids, "BG101")
        );
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] ids = {"BG101", "BG205", "BG309"};

        assertTrue(
                TrainService.searchBogieWithValidation(ids, "BG205")
        );
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] ids = {"BG101", "BG205", "BG309"};

        assertFalse(
                TrainService.searchBogieWithValidation(ids, "BG999")
        );
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] ids = {"BG101"};

        assertTrue(
                TrainService.searchBogieWithValidation(ids, "BG101")
        );
    }
}