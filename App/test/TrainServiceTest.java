import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TrainServiceTest {

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 50),
                new Bogie("General", 90)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = TrainService.filterHighCapacityBogies(getSampleBogies(), 70);
        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = TrainService.filterHighCapacityBogies(getSampleBogies(), 72);
        assertEquals(1, result.size()); // only 90
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = TrainService.filterHighCapacityBogies(getSampleBogies(), 80);
        assertEquals(1, result.size());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = TrainService.filterHighCapacityBogies(getSampleBogies(), 50);
        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = TrainService.filterHighCapacityBogies(getSampleBogies(), 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = TrainService.filterHighCapacityBogies(getSampleBogies(), 40);
        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = TrainService.filterHighCapacityBogies(new ArrayList<>(), 70);
        assertTrue(result.isEmpty());
    }



    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();
        TrainService.filterHighCapacityBogies(original, 70);
        assertEquals(4, original.size());
    }
}