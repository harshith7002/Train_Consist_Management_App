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

    private List<Bogie> getLargeDataset() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Bogie("Type" + i, i % 100));
        }
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = TrainService.filterUsingLoop(getSampleBogies());
        assertEquals(2, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = TrainService.filterUsingStream(getSampleBogies());
        assertEquals(2, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = TrainService.filterUsingLoop(getSampleBogies());
        List<Bogie> streamResult = TrainService.filterUsingStream(getSampleBogies());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long loopTime = TrainService.measureLoopTime(getSampleBogies());
        long streamTime = TrainService.measureStreamTime(getSampleBogies());

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> largeData = getLargeDataset();

        List<Bogie> result = TrainService.filterUsingStream(largeData);

        assertNotNull(result);
    }
}