import java.util.*;

// A console-based E-Commerce app: browse products, add to cart, checkout.
public class ECommerceConsoleApplication {

    record Product(int id, String name, double price) {}

    static List<Product> catalog = List.of(
        new Product(1, "Wireless Mouse", 599),
        new Product(2, "Mechanical Keyboard", 2499),
        new Product(3, "USB-C Hub", 1299),
        new Product(4, "Laptop Stand", 899),
        new Product(5, "Webcam 1080p", 1799)
    );

    static Map<Product, Integer> cart = new LinkedHashMap<>(); // product -> quantity
    static Scanner sc = new Scanner(System.in);

    static void showCatalog() {
        System.out.println("\n--- Product Catalog ---");
        for (Product p : catalog) {
            System.out.printf("%d. %-20s ₹%.2f%n", p.id(), p.name(), p.price());
        }
    }

    static void addToCart() {
        showCatalog();
        System.out.print("Enter product ID to add: ");
        int id = Integer.parseInt(sc.nextLine().trim());

        Optional<Product> found = catalog.stream().filter(p -> p.id() == id).findFirst();
        if (found.isEmpty()) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = Integer.parseInt(sc.nextLine().trim());
        if (qty <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }

        cart.merge(found.get(), qty, Integer::sum);
        System.out.println("Added to cart: " + found.get().name() + " x " + qty);
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("\n--- Your Cart ---");
        double total = 0;
        for (var entry : cart.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            double subtotal = p.price() * qty;
            total += subtotal;
            System.out.printf("%-20s x%d = ₹%.2f%n", p.name(), qty, subtotal);
        }
        System.out.printf("Total: ₹%.2f%n", total);
    }

    static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Add something first!");
            return;
        }
        viewCart();
        System.out.println("\nProcessing payment...");
        System.out.println("Order placed successfully! Thank you for shopping with us.");
        cart.clear();
    }

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=== Welcome to the Java E-Commerce Store ===");

        while (running) {
            System.out.println("\n1. Browse Products\n2. Add to Cart\n3. View Cart\n4. Checkout\n5. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> showCatalog();
                case "2" -> addToCart();
                case "3" -> viewCart();
                case "4" -> checkout();
                case "5" -> { running = false; System.out.println("Goodbye!"); }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
