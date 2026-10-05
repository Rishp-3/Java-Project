# FileWriter in Java

## 📌 Topic
`FileWriter` text file me data likhne ki class hai. Default me ye purana data overwrite kar deta hai.

## 🎯 What You Will Learn

- `FileWriter` se file me likhna
- Overwrite aur append mode
- `write()` method
- File close karna

## 💻 Code

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Filewriter {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("notes.txt")) {
            fw.write("Line 1\n");
            fw.write("Line 2\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (FileWriter fw = new FileWriter("notes.txt", true)) {
            fw.write("Line 3 (appended)\n");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (FileReader fr = new FileReader("notes.txt")) {
            int ch;
            while ((ch = fr.read()) != -1) System.out.print((char) ch);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

## 🧠 Explanation

### `new FileWriter("notes.txt")`
File nahi hai to bana deta hai, hai to purana content mita deta hai (overwrite).

### `new FileWriter("notes.txt", true)`
Dusra argument `true` ho to purane content ke baad append karta hai.

### `\n`
Nayi line ke liye `\n` khud likhna padta hai.

## ▶️ Output

```text
Line 1
Line 2
Line 3 (appended)
```

## 🔑 Important Points

- Close ya flush na karne par data file me likha hi nahi jata.
- `BufferedWriter` ke saath bade data ke liye zyada fast hota hai.
- Encoding specify karni ho to `FileWriter(file, StandardCharsets.UTF_8)` (Java 11+).

## 📝 Practice

1. Apna naam aur city ek file me likho.
2. Append mode me 3 lines jodo.
3. User se input lekar file me likho.
4. Numbers 1 se 10 file me likho.

## 🚀 Challenge

User se ek sentence lo aur use `log.txt` me append karo.
