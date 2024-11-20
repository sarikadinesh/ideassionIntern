public class Main {
    public static void main(String[] args) {
        // Create peripheral devices with unique IDs
        PeripheralDevice keyboard = new PeripheralDevice(101, "Keyboard");
        PeripheralDevice mouse = new PeripheralDevice(102, "Mouse");
        PeripheralDevice monitor = new PeripheralDevice(103, "Monitor");

        // Create a computer with a unique ID and add peripheral devices
        Computer computer = new Computer(1, "Dell");
        computer.addPeripheral(keyboard);
        computer.addPeripheral(mouse);
        computer.addPeripheral(monitor);

        // Display computer and its peripherals
        computer.displayInfo();
    }
}
