import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainServiceTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] ids = {
                "BG101", "BG205",
                "BG309", "BG412",
                "BG550"
        };

        assertTrue(
                TrainService.binarySearchBogieId(ids, "BG309")
        );
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] ids = {
                "BG101", "BG205",
                "BG309", "BG412",
                "BG550"
        };

        assertFalse(
                TrainService.binarySearchBogieId(ids, "BG999")
        );
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] ids = {
                "BG101", "BG205",
                "BG309", "BG412",
                "BG550"
        };

        assertTrue(
                TrainService.binarySearchBogieId(ids, "BG101")
        );
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] ids = {
                "BG101", "BG205",
                "BG309", "BG412",
                "BG550"
        };

        assertTrue(
                TrainService.binarySearchBogieId(ids, "BG550")
        );
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] ids = {"BG101"};

        assertTrue(
                TrainService.binarySearchBogieId(ids, "BG101")
        );
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] ids = {};

        assertFalse(
                TrainService.binarySearchBogieId(ids, "BG101")
        );
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] ids = {
                "BG309", "BG101",
                "BG550", "BG205",
                "BG412"
        };

        assertTrue(
                TrainService.binarySearchBogieId(ids, "BG205")
        );
    }
}