import java.util.Arrays;

public class TrainService {

    public static boolean binarySearchBogieId(String[] bogieIds, String searchKey) {

        Arrays.sort(bogieIds); // handles unsorted input

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare = searchKey.compareTo(bogieIds[mid]);

            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}