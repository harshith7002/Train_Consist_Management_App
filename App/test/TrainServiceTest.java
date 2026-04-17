import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainServiceTest {

    @Test
    void testCargo_SafeAssignment() {
        Bogie b = new Bogie("Cylindrical", 100);

        boolean result = TrainService.assignCargo(b, "Petroleum");

        assertTrue(result);
        assertEquals("Petroleum", b.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        Bogie b = new Bogie("Rectangular", 80);

        boolean result = TrainService.assignCargo(b, "Petroleum");

        assertFalse(result);
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        Bogie b = new Bogie("Rectangular", 80);

        TrainService.assignCargo(b, "Petroleum");

        assertNull(b.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        Bogie b1 = new Bogie("Rectangular", 80);
        Bogie b2 = new Bogie("Cylindrical", 90);

        TrainService.assignCargo(b1, "Petroleum");
        boolean result = TrainService.assignCargo(b2, "Petroleum");

        assertTrue(result);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        Bogie b = new Bogie("Rectangular", 80);

        boolean result = TrainService.assignCargo(b, "Coal");

        assertTrue(result);
    }
}