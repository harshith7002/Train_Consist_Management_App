import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainServiceTest {

    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("Sleeper", 72);
        assertNotNull(b);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", -10);
        });
        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", 0);
        });
        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        Bogie b = new Bogie("AC Chair", 60);

        assertEquals("AC Chair", b.getType());
        assertEquals(60, b.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        Bogie b1 = new Bogie("Sleeper", 72);
        Bogie b2 = new Bogie("First Class", 50);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}