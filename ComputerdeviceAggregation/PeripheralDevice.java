public class PeripheralDevice {
    private int id; // Unique ID for the peripheral device
    private String name;

    public PeripheralDevice(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
