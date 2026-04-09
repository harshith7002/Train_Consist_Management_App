import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainServiceTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainService.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainService.isValidTrainId("TRAIN12"));
        assertFalse(TrainService.isValidTrainId("TRN12A"));
        assertFalse(TrainService.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainService.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainService.isValidCargoCode("PET-ab"));
        assertFalse(TrainService.isValidCargoCode("PET123"));
        assertFalse(TrainService.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainService.isValidTrainId("TRN-123"));
        assertFalse(TrainService.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainService.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainService.isValidTrainId(""));
        assertFalse(TrainService.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainService.isValidTrainId("TRN-1234-EXTRA"));
        assertFalse(TrainService.isValidCargoCode("PET-ABCD"));
    }
}