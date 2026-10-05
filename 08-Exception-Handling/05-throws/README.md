# throws in Java

## 📌 Topic
`throws` method ke signature me likha jata hai ki ye method kaun si checked exceptions throw kar sakta hai. Handle karne ki zimmedari caller par hoti hai.

## 🎯 What You Will Learn

- Checked aur Unchecked exceptions
- `throws` keyword ka use
- Exception ko caller tak propagate karna

## 💻 Code

```java
import java.io.FileReader;
import java.io.IOException;

public class Throws {

    static void readFile(String path) throws IOException {
        FileReader fr = new FileReader(path);
        fr.close();
    }

    public static void main(String[] args) {
        try {
            readFile("missing.txt");
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}
```

## 🧠 Explanation

### `throws IOException`
Compiler ko batata hai ki ye method `IOException` throw kar sakta hai.

### `Checked exception`
Compile time par check hoti hai (`IOException`, `SQLException`). Inko `try-catch` ya `throws` se handle karna zaroori hai.

### `Unchecked exception`
Runtime par aati hai (`NullPointerException`, `ArithmeticException`). Inko handle karna zaroori nahi.

## ▶️ Output

```text
Could not read file: missing.txt (No such file or directory)
```

## 🔑 Important Points

- Ek se zyada exceptions ke liye comma lagao: `throws IOException, SQLException`.
- `main()` bhi `throws Exception` likh sakta hai, par ye achhi practice nahi.
- Exception ko wahin handle karo jahan uska matlab ho.

## 📝 Practice

1. Ek method banao jo `throws InterruptedException` ho (`Thread.sleep`).
2. Do-teen methods ke chain me exception propagate karo.
3. Checked exception ko bina handle kiye compile error dekho.
4. `throws` aur `try-catch` dono ka use ek program me karo.

## 🚀 Challenge

`throw` aur `throws` ka difference apne words me 4 points me likho.
