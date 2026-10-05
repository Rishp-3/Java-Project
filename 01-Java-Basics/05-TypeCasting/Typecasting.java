public class Typecasting {
    public static void main(String[] args) {

        // Widening
        int number = 100;
        double doubleNumber = number;

        System.out.println("Widening:");
        System.out.println("int: " + number);
        System.out.println("double: " + doubleNumber);

        // Narrowing
        double price = 99.99;
        int intPrice = (int) price;

        System.out.println("\nNarrowing:");
        System.out.println("double: " + price);
        System.out.println("int: " + intPrice);

        // char to int
        char letter = 'A';
        int unicode = letter;

        System.out.println("\nCharacter:");
        System.out.println("Character: " + letter);
        System.out.println("Unicode: " + unicode);
    }
}
