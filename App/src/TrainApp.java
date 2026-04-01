import java.util.LinkedHashSet;

public class TrainApp {
    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // LinkedHashSet for ordered + unique bogies
        LinkedHashSet<String> train = new LinkedHashSet<>();

        // Adding bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("Cargo");
        train.add("Guard");

        // محاولة إضافة عنصر مكرر (duplicate)
        train.add("Sleeper");

        // Display final formation
        System.out.println("\nFinal train formation (no duplicates, order preserved):");
        System.out.println(train);

        System.out.println("\nProgram continues...");
    }
}