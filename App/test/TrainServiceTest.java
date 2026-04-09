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
    void testReduce_TotalSeatCalculation() {
        int total = TrainService.calculateTotalSeats(getSampleBogies());
        assertEquals(272, total); // 72 + 60 + 50 + 90
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = TrainService.calculateTotalSeats(getSampleBogies());
        assertTrue(total > 0);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 70)
        );

        int total = TrainService.calculateTotalSeats(list);
        assertEquals(70, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int total = TrainService.calculateTotalSeats(new ArrayList<>());
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        int total = TrainService.calculateTotalSeats(getSampleBogies());
        assertEquals(272, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        int total = TrainService.calculateTotalSeats(getSampleBogies());
        assertEquals(272, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();

        TrainService.calculateTotalSeats(original);

        assertEquals(4, original.size());
    }
}