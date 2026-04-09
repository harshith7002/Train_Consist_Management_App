public class Bogie {
    private String type;
    private int capacity;
    private String cargo;


    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.cargo = ""; // default
    }


    public Bogie(String type, int capacity, String cargo) {
        this.type = type;
        this.capacity = capacity;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getCargo() {
        return cargo;
    }
}