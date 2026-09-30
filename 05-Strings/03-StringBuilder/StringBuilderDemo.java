public class StringBuilderDemo {
    public static void main(String[] args) {

        // Unlike String, StringBuilder is mutable - operations modify the same object
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" World");             // Hello World
        System.out.println("After append: " + sb);

        sb.insert(5, ",");                // Hello, World
        System.out.println("After insert: " + sb);

        sb.replace(0, 5, "Hi");           // Hi, World
        System.out.println("After replace: " + sb);

        sb.delete(0, 2);                  // , World
        System.out.println("After delete: " + sb);

        sb.reverse();
        System.out.println("Reversed: " + sb);

        // Building a string efficiently in a loop (much faster than String += in a loop)
        StringBuilder loopBuilder = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            loopBuilder.append(i).append(" ");
        }
        System.out.println("Built in loop: " + loopBuilder.toString().trim());

        System.out.println("Length: " + sb.length());
        System.out.println("charAt(1): " + sb.charAt(1));
    }
}
