public class Computer {

    
    private final String cpu;
    private final String ram;

    
    private final String storage;
    private final String gpu;
    private final String powerSupply;
    private final boolean wifiEnabled;
    private final boolean bluetoothEnabled;

    
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.powerSupply = builder.powerSupply;
        this.wifiEnabled = builder.wifiEnabled;
        this.bluetoothEnabled = builder.bluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpu='" + gpu + '\'' +
                ", powerSupply='" + powerSupply + '\'' +
                ", wifiEnabled=" + wifiEnabled +
                ", bluetoothEnabled=" + bluetoothEnabled +
                '}';
    }

    
    public static class Builder {
        private final String cpu;
        private final String ram;

        private String storage = "256GB SSD";      
        private String gpu = "Integrated Graphics";
        private String powerSupply = "500W";
        private boolean wifiEnabled = true;
        private boolean bluetoothEnabled = true;

        
        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder powerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder wifiEnabled(boolean wifiEnabled) {
            this.wifiEnabled = wifiEnabled;
            return this;
        }

        public Builder bluetoothEnabled(boolean bluetoothEnabled) {
            this.bluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
