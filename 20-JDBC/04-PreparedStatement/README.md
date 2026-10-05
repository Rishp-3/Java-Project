# PreparedStatement in JDBC

## 📌 Topic
`PreparedStatement` pre-compiled SQL query hoti hai jisme `?` placeholders hote hain. Ye SQL Injection se bachati hai aur repeated queries me fast hoti hai.

## 🎯 What You Will Learn

- `PreparedStatement` aur `?` placeholders
- `setInt()`, `setString()`
- SQL Injection se bachna
- Batch insert

## 💻 Code

```java
import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/college";

        try (Connection con = DriverManager.getConnection(url, "root", "password")) {

            String insert = "INSERT INTO students(name, age) VALUES(?, ?)";
            try (PreparedStatement ps = con.prepareStatement(insert)) {
                ps.setString(1, "Neha");
                ps.setInt(2, 21);
                System.out.println(ps.executeUpdate() + " row inserted");
            }

            String select = "SELECT * FROM students WHERE age > ?";
            try (PreparedStatement ps = con.prepareStatement(select)) {
                ps.setInt(1, 20);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getString("name") + " (" + rs.getInt("age") + ")");
                    }
                }
            }
        }
    }
}
```

> 💡 Note: JDBC ke liye ek database (jaise MySQL) aur uska JDBC driver (`mysql-connector-j.jar`) classpath me hona chahiye. Isliye yahan output sample hai, jo setup ke baad aisa dikhega.

## 🧠 Explanation

### `?`
Placeholder. Value baad me `setXxx(index, value)` se di jati hai.

### `setString(1, ...)`
Index 1 se start hota hai (pehla `?`).

### `SQL Injection safe`
Values SQL text me nahi judti, alag parameter ki tarah jati hain, isliye malicious input query nahi badal sakta.

## ▶️ Output

```text
1 row inserted
Neha (21)
```

## 🔑 Important Points

- Hamesha `PreparedStatement` use karo jab user input ho.
- Batch ke liye `addBatch()` aur `executeBatch()` hote hain.
- Table ya column ke naam `?` se nahi de sakte, sirf values de sakte ho.

## 📝 Practice

1. `Statement` wala insert `PreparedStatement` se likho.
2. Login check banao (username/password) PreparedStatement se.
3. Batch me 100 rows insert karo.
4. `setNull()` try karo.

## 🚀 Challenge

Login program banao: username aur password `PreparedStatement` se verify ho.
