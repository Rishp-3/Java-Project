public class StringBasics {
    public static void main(String[] args) {

        // Strings are immutable in Java - once created, a String object never changes
        String s1 = "Hello";
        String s2 = "Hello";      // reuses s1 from the String pool
        String s3 = new String("Hello"); // always creates a new object on the heap

        System.out.println("s1 == s2: " + (s1 == s2));   // true, same pooled reference
        System.out.println("s1 == s3: " + (s1 == s3));   // false, different objects
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true, same content

        // Basic properties
        String name = "Rishabh Kumar";
        System.out.println("Length: " + name.length());
        System.out.println("Uppercase: " + name.toUpperCase());
        System.out.println("Lowercase: " + name.toLowerCase());

        // Concatenation
        String greeting = "Hello" + ", " + "Java!";
        System.out.println(greeting);

        // Because String is immutable, concatenation creates a NEW string each time
        String a = "abc";
        String b = a.concat("def");
        System.out.println("a = " + a + " (unchanged)");
        System.out.println("b = " + b + " (new string)");
    }
}
