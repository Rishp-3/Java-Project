# Statement in JDBC

## 📌 Topic
`Statement` ka use fixed SQL queries chalane ke liye hota hai. `executeQuery()` data padhne ke liye aur `executeUpdate()` insert/update/delete ke liye.

## 🎯 What You Will Learn

- `Statement` object banana
- `executeQuery()` aur `executeUpdate()`
- `ResultSet` se data padhna
- Statement ki limitation (SQL Injection)

## 💻 Code

```java
import java.sql.*;

public class StatementDemo {
    public static void main(String[] args) throws SQLException {
        try (Connection con = DriverManager.getConnection(
                "jdbc:h2:mem:college;DB_CLOSE_DELAY=-1", "sa", "");
             Statement st = con.createStatement()) {

            int rows = st.executeUpdate("INSERT INTO students(name, age) VALUES('Rishabh', 20)");
            System.out.println(rows + " row inserted");

            try (ResultSet rs = st.executeQuery("SELECT * FROM students")) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));
                }
            }
        }
    }
}
```

> 💡 Note: ab ye module H2 (embedded database) use karta hai, isliye koi alag database install nahi karna padta. Run karne ke liye H2 jar classpath me do: `java -cp .:h2.jar ClassName` (Windows par `;` use karo), ya project root se Maven use karo. MySQL chahiye to URL, user, password badlo aur `mysql-connector-j` add karo.

## 🧠 Explanation

### `executeUpdate()`
INSERT, UPDATE, DELETE ke liye. Kitni rows affect hui wo `int` me deta hai.

### `executeQuery()`
SELECT ke liye. `ResultSet` return karta hai.

### `SQL Injection`
User input ko seedha SQL string me jodna khatarnak hai. Iska solution `PreparedStatement` hai (agla topic).

## ▶️ Output

```text
1 row inserted
1 Rishabh 20
```

## 🔑 Important Points

- `ResultSet` ke columns ko naam ya index (1 se start) se padh sakte ho.
- Statement me user input kabhi concatenate mat karo.
- `execute()` kisi bhi type ki query chala sakta hai.

## 📝 Practice

1. Table me 3 students insert karo.
2. Ek student ki age update karo.
3. Ek student ko delete karo.
4. SQL Injection ka example samjho (`' OR '1'='1`).

## 🚀 Challenge

`Statement` se `students` table ke saare records age ke hisab se sorted print karo.
