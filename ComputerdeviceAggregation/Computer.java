import java.util.*;

public class Computer {
    private List<PeripheralDevice> peripheralDevices;

    public Computer() {
        peripheralDevices = new ArrayList<>();
    }

    public void addPeripheralDevice(PeripheralDevice peripheralDevice) {
        peripheralDevices.add(peripheralDevice);
    }

    public void showPeripheralDevices() {
        for (PeripheralDevice device : peripheralDevices) {
            System.out.println(device.getDeviceName());
        }
    }
}
