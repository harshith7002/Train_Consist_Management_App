import java.util.*;
import java.util.stream.Collectors;

public class TrainService {

    // Loop-based filtering
    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    // Measure loop performance
    public static long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingLoop(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    // Measure stream performance
    public static long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterUsingStream(bogies);
        long end = System.nanoTime();
        return end - start;
    }
}