# Writer in Java

## 📌 Topic
`Writer` character data likhne ki abstract class hai. Text files aur strings me likhne ke liye use hoti hai.

## 🎯 What You Will Learn

- `Writer`, `FileWriter`, `StringWriter`, `OutputStreamWriter`
- `BufferedWriter` aur `PrintWriter`
- Encoding ke saath likhna

## 💻 Code

```java
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Writer1 {
    public static void main(String[] args) throws IOException {
        StringWriter sw = new StringWriter();
        sw.write("Hello ");
        sw.write("Writer");
        System.out.println(sw);

        try (Writer w = new OutputStreamWriter(new FileOutputStream("utf8.txt"), StandardCharsets.UTF_8)) {
            w.write("Namaste Java");
        }

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("report.txt")))) {
            pw.println("Report");
            pw.printf("Total: %d items%n", 5);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("report.txt"))) {
            String line;
            while ((line = br.readLine()) != null) System.out.println(line);
        }
        new File("utf8.txt").delete();
        new File("report.txt").delete();
    }
}
```

## 🧠 Explanation

### `StringWriter`
Text ko memory me jama karta hai, baad me `toString()` se string milti hai.

### `OutputStreamWriter`
Character ko bytes me badalta hai, encoding choose kar sakte ho.

### `PrintWriter`
`println()` aur `printf()` jaise convenient methods deta hai, file ya console dono ke liye.

## ▶️ Output

```text
Hello Writer
Report
Total: 5 items
```

## 🔑 Important Points

- `Writer` ko close karna zaroori hai warna data flush nahi hota.
- `BufferedWriter` ke saath writing fast hoti hai.
- Binary data ke liye `OutputStream` use karo.

## 📝 Practice

1. `StringWriter` se string banao.
2. `PrintWriter` se table jaisa report file me likho.
3. UTF-8 me Hindi text likho.
4. `BufferedWriter` me `newLine()` use karo.

## 🚀 Challenge

Student marks ka report `PrintWriter` se `report.txt` me formatted (`printf`) likho.
