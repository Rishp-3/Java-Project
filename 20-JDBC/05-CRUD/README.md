# CRUD Operations in JDBC

## 📌 Topic
CRUD ka matlab Create, Read, Update, Delete. Ye database ke 4 basic operations hain jo har application me hote hain.

## 🎯 What You Will Learn

- Create (INSERT)
- Read (SELECT)
- Update (UPDATE)
- Delete (DELETE)

## 💻 Code

```java
import java.sql.*;

public class Crud {

    static final String URL = "jdbc:h2:mem:college;DB_CLOSE_DELAY=-1";

    static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, "sa", "");
    }

    static void create(String name, int age) throws SQLException {
        try (Connection c = connect();
             PreparedStatement ps = c.prepareStatement("INSERT INTO students(name, age) VALUES(?, ?)")) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();
        }
    }

    static void read() throws SQLException {
        try (Connection c = connect();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }
        }
    }

    static void update(int id, int age) throws SQLException {
        try (Connection c = connect();
             PreparedStatement ps = c.prepareStatement("UPDATE students SET age = ? WHERE id = ?")) {
            ps.setInt(1, age);
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }

    static void delete(int id) throws SQLException {
        try (Connection c = connect();
             PreparedStatement ps = c.prepareStatement("DELETE FROM students WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public static void main(String[] args) throws SQLException {
        create("Rishabh", 20);
        create("Amit", 22);
        read();
        update(1, 21);
        delete(2);
        System.out.println("After update and delete:");
        read();
    }
}
```

> 💡 Note: ab ye module H2 (embedded database) use karta hai, isliye koi alag database install nahi karna padta. Run karne ke liye H2 jar classpath me do: `java -cp .:h2.jar ClassName` (Windows par `;` use karo), ya project root se Maven use karo. MySQL chahiye to URL, user, password badlo aur `mysql-connector-j` add karo.

## 🧠 Explanation

### `create()`
`INSERT` se nayi row jodta hai.

### `read()`
`SELECT` se rows padhta hai.

### `update()`
`UPDATE ... WHERE id = ?` se row badalta hai. `WHERE` bhoolne par saari rows badal jati hain.

### `delete()`
`DELETE ... WHERE id = ?` se row hatata hai.

## ▶️ Output

```text
1 Rishabh 20
2 Amit 22
After update and delete:
1 Rishabh 21
```

## 🔑 Important Points

- `UPDATE` aur `DELETE` me `WHERE` zaroor lagao.
- Har operation ko alag method me rakhne se code clean rehta hai.
- Agle step me ye methods ek `StudentDAO` class me daal do (DAO pattern).

## 📝 Practice

1. `findById(int id)` method banao.
2. `searchByName(String name)` banao (`LIKE`).
3. Duplicate naam insert hone se roko.
4. Transaction (`commit`/`rollback`) try karo.

## 🚀 Challenge

CRUD ke saath ek console menu banao: 1 Add, 2 View, 3 Update, 4 Delete, 5 Exit.
