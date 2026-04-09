import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainServiceTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Cylindrical", 100, "Petroleum"),
                new Bogie("Box", 80, "Coal")
        );

        assertTrue(TrainService.isTrainSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Cylindrical", 100, "Coal")
        );

        assertFalse(TrainService.isTrainSafe(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Open", 70, "Grain"),
                new Bogie("Box", 80, "Coal")
        );

        assertTrue(TrainService.isTrainSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Cylindrical", 100, "Petroleum"),
                new Bogie("Cylindrical", 90, "Coal")
        );

        assertFalse(TrainService.isTrainSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        assertTrue(TrainService.isTrainSafe(list));
    }
}