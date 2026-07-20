public class ComputerTest {
    public static void main(String[] args) {
        Computer officeComputer = new Computer.Builder("Intel i5", "8GB")
                .storage("512GB SSD")
                .build();

        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .storage("2TB NVMe SSD")
                .gpu("NVIDIA RTX 4090")
                .powerSupply("850W")
                .bluetoothEnabled(true)
                .wifiEnabled(true)
                .build();

        Computer budgetComputer = new Computer.Builder("AMD Ryzen 3", "4GB")
                .wifiEnabled(false)
                .bluetoothEnabled(false)
                .build();

        System.out.println("Office PC: " + officeComputer);
        System.out.println("Gaming PC: " + gamingComputer);
        System.out.println("Budget PC: " + budgetComputer);
    }
}
