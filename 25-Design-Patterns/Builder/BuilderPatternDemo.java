public class BuilderPatternDemo {

    // Builder: constructs a complex object step by step, avoiding
    // constructors with a huge number of parameters ("telescoping constructors").
    static class Computer {
        // required
        private final String cpu;
        private final String ram;
        // optional
        private final String storage;
        private final boolean hasGraphicsCard;
        private final boolean hasWifi;

        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.hasGraphicsCard = builder.hasGraphicsCard;
            this.hasWifi = builder.hasWifi;
        }

        @Override
        public String toString() {
            return "Computer{cpu=" + cpu + ", ram=" + ram + ", storage=" + storage +
                ", graphicsCard=" + hasGraphicsCard + ", wifi=" + hasWifi + "}";
        }

        static class Builder {
            private final String cpu;
            private final String ram;
            private String storage = "256GB SSD"; // sensible default
            private boolean hasGraphicsCard = false;
            private boolean hasWifi = true;

            Builder(String cpu, String ram) { // required fields go in the Builder's constructor
                this.cpu = cpu;
                this.ram = ram;
            }

            Builder storage(String storage) {
                this.storage = storage;
                return this; // returning 'this' enables method chaining
            }

            Builder graphicsCard(boolean hasGraphicsCard) {
                this.hasGraphicsCard = hasGraphicsCard;
                return this;
            }

            Builder wifi(boolean hasWifi) {
                this.hasWifi = hasWifi;
                return this;
            }

            Computer build() {
                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {
        Computer basic = new Computer.Builder("Intel i5", "8GB").build();
        System.out.println(basic);

        Computer gamingPc = new Computer.Builder("Intel i9", "32GB")
            .storage("2TB SSD")
            .graphicsCard(true)
            .wifi(true)
            .build();
        System.out.println(gamingPc);
    }
}
