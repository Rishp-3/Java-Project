import java.util.*;

// A console-based Library Management System: add books, issue, return, and search.
public class LibraryManagementSystem {

    static class Book {
        int id;
        String title;
        String author;
        boolean issued;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.issued = false;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | " + title + " by " + author +
                (issued ? " [ISSUED]" : " [AVAILABLE]");
        }
    }

    static List<Book> books = new ArrayList<>();
    static int nextId = 1;
    static Scanner sc = new Scanner(System.in);

    static void addBook() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        books.add(new Book(nextId++, title, author));
        System.out.println("Book added successfully.");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        books.forEach(System.out::println);
    }

    static void issueBook() {
        System.out.print("Enter book ID to issue: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Book b : books) {
            if (b.id == id) {
                if (b.issued) {
                    System.out.println("Sorry, this book is already issued.");
                } else {
                    b.issued = true;
                    System.out.println("Book issued: " + b.title);
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Book b : books) {
            if (b.id == id) {
                b.issued = false;
                System.out.println("Book returned: " + b.title);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void searchByTitle() {
        System.out.print("Enter title keyword: ");
        String keyword = sc.nextLine().toLowerCase();
        books.stream()
            .filter(b -> b.title.toLowerCase().contains(keyword))
            .forEach(System.out::println);
    }

    public static void main(String[] args) {
        // seed a few sample books
        books.add(new Book(nextId++, "The Java Handbook", "Herbert Schildt"));
        books.add(new Book(nextId++, "Clean Code", "Robert C. Martin"));
        books.add(new Book(nextId++, "Effective Java", "Joshua Bloch"));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book\n2. View All Books\n3. Issue Book\n4. Return Book\n5. Search by Title\n6. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> addBook();
                case "2" -> viewBooks();
                case "3" -> issueBook();
                case "4" -> returnBook();
                case "5" -> searchByTitle();
                case "6" -> { running = false; System.out.println("Goodbye!"); }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
