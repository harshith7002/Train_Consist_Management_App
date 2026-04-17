public class TrainService {

    public static boolean searchBogieWithValidation(String[] bogieIds, String searchKey) {

        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        for (String id : bogieIds) {
            if (id.equals(searchKey)) {
                return true;
            }
        }

        return false;
    }
}