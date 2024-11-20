public class Main {
    public static void main(String[] args) {
        PeripheralDevice device1 = new PeripheralDevice("Mouse");
        PeripheralDevice device2 = new PeripheralDevice("Keyboard");
        PeripheralDevice device3 = new PeripheralDevice("CPU");
       PeripheralDevice device4 = new PeripheralDevice("Earphones");

        Computer computer = new Computer();
        computer.addPeripheralDevice(device1);
        computer.addPeripheralDevice(device2);
        computer.addPeripheralDevice(device3);
        computer.addPeripheralDevice(device4);

        computer.showPeripheralDevices();  
    }
}
