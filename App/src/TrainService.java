public class TrainService {

    public static boolean linearSearchBogieId(String[] bogieIds, String searchKey) {

        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                return true;
            }
        }

        return false;
    }
}