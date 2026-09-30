public class StringBufferDemo {
    public static void main(String[] args) {

        // StringBuffer works just like StringBuilder, but it is thread-safe
        // (its methods are synchronized) which makes it slightly slower.
        // Use StringBuilder for single-threaded code, StringBuffer when
        // multiple threads modify the same buffer.

        StringBuffer buffer = new StringBuffer("Java");

        buffer.append(" is fun");
        System.out.println("After append: " + buffer);

        buffer.insert(0, ">> ");
        System.out.println("After insert: " + buffer);

        buffer.reverse();
        System.out.println("Reversed: " + buffer);
        buffer.reverse(); // reverse back

        buffer.deleteCharAt(0);
        System.out.println("After deleteCharAt: " + buffer);

        System.out.println("Capacity: " + buffer.capacity());
        System.out.println("Length: " + buffer.length());

        // Converting back to a normal String
        String result = buffer.toString();
        System.out.println("As String: " + result);
    }
}
