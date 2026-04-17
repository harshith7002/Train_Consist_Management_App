public class TrainService {

    public static boolean assignCargo(Bogie bogie, String cargo) {

        try {
            if (bogie.getType().equalsIgnoreCase("Rectangular")
                    && cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Petroleum cannot be assigned to Rectangular bogie");
            }

            bogie.setCargo(cargo);
            return true;

        } catch (CargoSafetyException e) {
            System.out.println(e.getMessage());
            return false;

        } finally {
            System.out.println("Cargo assignment completed.");
        }
    }
}