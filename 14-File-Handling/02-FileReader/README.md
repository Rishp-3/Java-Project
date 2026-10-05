# FileReader in Java

## 📌 Topic
`FileReader` text file ko character-by-character padhne ki class hai.

## 🎯 What You Will Learn

- `FileReader` se file padhna
- `read()` method aur `-1` (end of file)
- `try-with-resources` se file close karna
- File na mile to `FileNotFoundException`

## 💻 Code

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Filereader {
    public static void main(String[] args) {
        try (FileWriter w = new FileWriter("data.txt")) {
            w.write("Hello Java\nFile Handling");
        } catch (IOException e) {
            System.out.println("Write error");
        }

        try (FileReader fr = new FileReader("data.txt")) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}
```

## 🧠 Explanation

### `fr.read()`
Ek character padhta hai aur uska `int` code return karta hai. File khatam hone par `-1`.

### `(char) ch`
`int` ko wapas `char` me convert karna padta hai.

### `try (FileReader fr = ...)`
try-with-resources: block ke baad file automatically close ho jati hai.

## ▶️ Output

```text
Hello Java
File Handling
```

## 🔑 Important Points

- `FileReader` ek-ek character padhta hai, bade files ke liye `BufferedReader` behtar hai.
- File na ho to `FileNotFoundException` aati hai.
- File hamesha close karo, warna resource leak hota hai.

## 📝 Practice

1. File ke saare characters print karo.
2. File me kitne characters hain count karo.
3. File me vowels count karo.
4. Missing file padhne ki koshish karke exception pakdo.

## 🚀 Challenge

File me kitne lines hain, `FileReader` se `\n` count karke batao.
