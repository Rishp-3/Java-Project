# BufferedReader in Java

## 📌 Topic
`BufferedReader` text ko line-by-line padhne ki fast class hai. Ye data ko buffer me rakhta hai, isliye bade files ke liye efficient hai.

## 🎯 What You Will Learn

- `BufferedReader` aur `FileReader` ka combination
- `readLine()` se line-by-line padhna
- `BufferedWriter` ka use
- Console input ke liye `BufferedReader`

## 💻 Code

```java
import java.io.*;

public class Bufferedreader {
    public static void main(String[] args) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"))) {
            bw.write("Rishabh,85");
            bw.newLine();
            bw.write("Amit,72");
            bw.newLine();
            bw.write("Neha,92");
        }

        int total = 0, count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println(parts[0] + " scored " + parts[1]);
                total += Integer.parseInt(parts[1]);
                count++;
            }
        }
        System.out.println("Average: " + (double) total / count);
    }
}
```

## 🧠 Explanation

### `new BufferedReader(new FileReader(...))`
`FileReader` ko `BufferedReader` me wrap karte hain taaki line-by-line aur fast reading ho.

### `readLine()`
Ek poori line padhta hai. File khatam hone par `null` return karta hai.

### `bw.newLine()`
System ke hisab se sahi line separator likhta hai.

## ▶️ Output

```text
Rishabh scored 85
Amit scored 72
Neha scored 92
Average: 83.0
```

## 🔑 Important Points

- `readLine()` line ka `\n` hata deta hai.
- Bina buffer ke har `read()` disk par jata hai, buffer se bahut kam disk access hota hai.
- Java 8+ me `Files.readAllLines(Path)` aur `Files.lines(Path)` bhi use kar sakte ho.

## 📝 Practice

1. File ki saari lines print karo.
2. File me lines count karo.
3. File me ek word search karke us line ka number batao.
4. File ko copy karke dusri file me likho.

## 🚀 Challenge

`students.txt` se sabse zyada marks wale student ka naam print karo.
