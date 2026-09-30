public class Association {

    // Association: two classes are related, but each can exist independently.
    static class Teacher {
        String name;
        Teacher(String name) { this.name = name; }
    }

    static class Student {
        String name;
        Teacher teacher; // Student is associated with a Teacher
        Student(String name, Teacher teacher) {
            this.name = name;
            this.teacher = teacher;
        }
    }

    // Aggregation ("has-a", weak ownership): the Library does not own the Books' lifecycle
    static class Book {
        String title;
        Book(String title) { this.title = title; }
    }

    static class Library {
        java.util.List<Book> books;
        Library(java.util.List<Book> books) { this.books = books; }
    }

    // Composition ("owns-a", strong ownership): if the House is destroyed, so is the Room
    static class Room {
        String name;
        Room(String name) { this.name = name; }
    }

    static class House {
        private final Room room; // Room is created and destroyed with the House

        House() {
            this.room = new Room("Living Room");
        }
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Sharma");
        Student student = new Student("Rishabh", teacher);
        System.out.println(student.name + "'s teacher is " + student.teacher.name);

        Book b1 = new Book("Java Basics");
        Book b2 = new Book("Data Structures");
        Library library = new Library(java.util.List.of(b1, b2));
        System.out.println("Library has " + library.books.size() + " books (aggregation).");

        House house = new House();
        System.out.println("House built with room: " + house.room.name + " (composition).");
    }
}
