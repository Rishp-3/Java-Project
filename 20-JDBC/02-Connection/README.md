# JDBC Connection in Java

## 📌 Topic
`Connection` object Java program aur database ke beech ka session hota hai. Saari queries isi connection ke through chalti hain.

## 🎯 What You Will Learn

- `DriverManager.getConnection()`
- Connection URL, username, password
- Connection ko reusable method me rakhna
- Connection close karna

## 💻 Code

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:h2:mem:college;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection con = getConnection()) {
            System.out.println("Connected: " + !con.isClosed());
            System.out.println("Database: " + con.getCatalog());
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
```

> 💡 Note: ab ye module H2 (embedded database) use karta hai, isliye koi alag database install nahi karna padta. Run karne ke liye H2 jar classpath me do: `java -cp .:h2.jar ClassName` (Windows par `;` use karo), ya project root se Maven use karo. MySQL chahiye to URL, user, password badlo aur `mysql-connector-j` add karo.

## 🧠 Explanation

### `getConnection()`
Ek reusable static method, taaki har jagah URL/user/password dobara na likhna pade.

### `System.getenv("DB_PASSWORD")`
Password environment variable se aata hai, code me nahi likhna padta.

### `try (Connection con = ...)`
Block ke baad connection apne aap close ho jata hai.

## ▶️ Output

```text
Connected: true
Database: college
```

## 🔑 Important Points

- Connection mehnga resource hai, use kaam khatam hote hi close karo.
- Real apps me Connection Pool (HikariCP) use hota hai.
- Common errors: wrong password, DB server band, driver missing (`No suitable driver`).

## 📝 Practice

1. `DBConnection` utility class banao.
2. Galat password dekar exception dekho.
3. `DatabaseMetaData` se DB ka naam aur version print karo.
4. Environment variable se credentials pado.

## 🚀 Challenge

Connection details `db.properties` file me rakho aur `Properties` class se padho.
