# JDBC Basics in Java

## 📌 Topic
JDBC (Java Database Connectivity) ek API hai jisse Java program database (MySQL, PostgreSQL, Oracle) se connect hokar SQL queries chala sakta hai.

## 🎯 What You Will Learn

- JDBC kya hai aur kyu use hota hai
- JDBC ke 5 steps
- Driver, Connection, Statement, ResultSet
- `java.sql` package

## 💻 Code

```java
import java.sql.*;

public class JdbcBasics {
    public static void main(String[] args) {
        String url = "jdbc:h2:mem:college;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String pass = "";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, name FROM students")) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println("DB error: " + e.getMessage());
        }
    }
}
```

> 💡 Note: ab ye module H2 (embedded database) use karta hai, isliye koi alag database install nahi karna padta. Run karne ke liye H2 jar classpath me do: `java -cp .:h2.jar ClassName` (Windows par `;` use karo), ya project root se Maven use karo. MySQL chahiye to URL, user, password badlo aur `mysql-connector-j` add karo.

## 🧠 Explanation

### `Step 1: Driver`
Driver jar classpath me hona chahiye. Modern JDBC (4.0+) me `Class.forName()` ki zaroorat nahi.

### `Step 2: Connection`
`DriverManager.getConnection(url, user, pass)` database se connection banata hai.

### `Step 3-4: Statement + ResultSet`
`Statement` se query chalate hain aur `ResultSet` me rows milti hain.

### `Step 5: Close`
try-with-resources se `Connection`, `Statement`, `ResultSet` automatically close ho jate hain.

## ▶️ Output

```text
1 - Rishabh
2 - Amit
3 - Neha
```

## 🔑 Important Points

- JDBC URL format: `jdbc:h2:mem:name` (in-memory), `jdbc:h2:file:./data/name` (file par save hota hai) ya MySQL ke liye `jdbc:mysql://host:port/database`.
- `rs.next()` agli row par jata hai, row hone par `true` deta hai.
- Password code me hardcode mat karo (config file ya environment variable use karo).
- Maven me dependency: `com.h2database:h2` (MySQL ke liye `com.mysql:mysql-connector-j`).

## 📝 Practice

1. MySQL install karke ek `college` database banao.
2. `students` table banao (id, name, age).
3. JDBC driver ko project me add karo.
4. Table ki saari rows print karo.

## 🚀 Challenge

Ek `students` table banao aur Java se uski saari rows (id, name, age) print karo.
