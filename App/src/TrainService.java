public class TrainService {

    public static int[] bubbleSortCapacities(int[] capacities) {

        int n = capacities.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {

                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        return capacities;
    }
}