# JDBC Mini Project

## 📌 Topic
Is mini project me Student Management System banta hai jisme `Student` model, `StudentDAO` (database ka kaam) aur `Main` (menu) alag-alag classes me hote hain.

## 🎯 What You Will Learn

- Layers me code todna (Model, DAO, Main)
- DAO pattern
- `List<Student>` return karna
- Pure CRUD application

## 💻 Code

```java
import java.sql.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + " | " + name + " | " + age;
    }
}

class StudentDAO {
    private final String url = "jdbc:h2:mem:college;DB_CLOSE_DELAY=-1";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, "sa", "");
    }

    void add(Student s) throws SQLException {
        try (Connection c = connect();
             PreparedStatement ps = c.prepareStatement("INSERT INTO students(name, age) VALUES(?, ?)")) {
            ps.setString(1, s.name);
            ps.setInt(2, s.age);
            ps.executeUpdate();
        }
    }

    List<Student> getAll() throws SQLException {
        List<Student> list = new ArrayList<>();
        try (Connection c = connect();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
            }
        }
        return list;
    }

    boolean delete(int id) throws SQLException {
        try (Connection c = connect();
             PreparedStatement ps = c.prepareStatement("DELETE FROM students WHERE id = ?")) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}

public class JdbcProject {
    public static void main(String[] args) throws SQLException {
        StudentDAO dao = new StudentDAO();
        dao.add(new Student(0, "Rishabh", 20));
        dao.add(new Student(0, "Neha", 21));

        System.out.println("All students:");
        for (Student s : dao.getAll()) {
            System.out.println(s);
        }

        System.out.println("Deleted: " + dao.delete(2));
    }
}
```

> 💡 Note: ab ye module H2 (embedded database) use karta hai, isliye koi alag database install nahi karna padta. Run karne ke liye H2 jar classpath me do: `java -cp .:h2.jar ClassName` (Windows par `;` use karo), ya project root se Maven use karo. MySQL chahiye to URL, user, password badlo aur `mysql-connector-j` add karo.

## 🧠 Explanation

### `Student`
Model class: ek row ko object ke roop me represent karti hai.

### `StudentDAO`
Data Access Object: saara database ka kaam yahin hota hai. Baaki code ko SQL nahi dikhta.

### `JdbcProject (main)`
Sirf DAO ke methods call karta hai. UI aur database logic alag rehte hain.

## ▶️ Output

```text
All students:
1 | Rishabh | 20
2 | Neha | 21
Deleted: true
```

## 🔑 Important Points

- Layered design se code padhna, test karna aur badalna aasan hota hai.
- Real project me Connection Pool aur Spring JDBC/JPA use hote hain.
- Exceptions ko user-friendly message me badalo.

## 📝 Practice

1. `update()` method DAO me jodo.
2. Name se search ka option jodo.
3. Console menu banao.
4. Age validation (18+) jodo.

## 🚀 Challenge

Project me `Course` table aur `Student` ke saath relation (foreign key) jodo.
