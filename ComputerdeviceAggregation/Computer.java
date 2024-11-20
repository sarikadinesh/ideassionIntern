import java.util.ArrayList;
import java.util.List;

public class Computer {
    private int id; // Unique ID for the computer
    private String brand;
    private List<PeripheralDevice> peripherals;

    public Computer(int id, String brand) {
        this.id = id;
        this.brand = brand;
        this.peripherals = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void addPeripheral(PeripheralDevice device) {
        peripherals.add(device);
    }

    public void displayInfo() {
        System.out.println("Computer ID: " + id);
        System.out.println("Computer Brand: " + brand);
        System.out.println("Connected Peripheral Devices:");
        for (PeripheralDevice device : peripherals) {
            System.out.println(" - " + device.getId() + ": " + device.getName());
        }
    }
}
