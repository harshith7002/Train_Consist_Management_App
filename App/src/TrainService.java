import java.util.List;
import java.util.stream.Collectors;

public class TrainService {

    public static List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }
}