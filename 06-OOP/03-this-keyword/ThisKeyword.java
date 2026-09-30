public class ThisKeyword {

    static class Rectangle {
        int width;
        int height;

        Rectangle(int width, int height) {
            // 'this.width' is the field, 'width' is the parameter - 'this' resolves the ambiguity
            this.width = width;
            this.height = height;
        }

        int area() {
            return this.width * this.height;
        }

        // 'this' can be passed as an argument to refer to the current object
        void compareTo(Rectangle other) {
            if (this.area() > other.area()) {
                System.out.println("This rectangle is bigger.");
            } else {
                System.out.println("The other rectangle is bigger or equal.");
            }
        }

        // 'this' can also be returned to allow method chaining
        Rectangle setWidth(int width) {
            this.width = width;
            return this;
        }

        Rectangle setHeight(int height) {
            this.height = height;
            return this;
        }
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(3, 3);

        System.out.println("r1 area: " + r1.area());
        System.out.println("r2 area: " + r2.area());
        r1.compareTo(r2);

        // Method chaining using 'this'
        Rectangle r3 = new Rectangle(0, 0).setWidth(10).setHeight(20);
        System.out.println("r3 area: " + r3.area());
    }
}
