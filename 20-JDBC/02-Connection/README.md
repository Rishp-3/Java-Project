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

    private static final String URL = "jdbc:mysql://localhost:3306/college";
    private static final String USER = "root";
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

> 💡 Note: JDBC ke liye ek database (jaise MySQL) aur uska JDBC driver (`mysql-connector-j.jar`) classpath me hona chahiye. Isliye yahan output sample hai, jo setup ke baad aisa dikhega.

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
