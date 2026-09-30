public class ConstructorDemo {

    static class Student {
        String name;
        int age;

        // Default constructor
        Student() {
            this("Unknown", 0); // calls the parameterized constructor below
        }

        // Parameterized constructor
        Student(String name, int age) {
            this.name = name; // 'this' refers to the current object's field
            this.age = age;
        }

        // Copy constructor
        Student(Student other) {
            this.name = other.name;
            this.age = other.age;
        }

        void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student();               // uses default constructor
        Student s2 = new Student("Rishabh", 22);   // uses parameterized constructor
        Student s3 = new Student(s2);              // uses copy constructor

        s1.display();
        s2.display();
        s3.display();

        System.out.println("s2 and s3 have the same data but are different objects: " + (s2 != s3));
    }
}
