# Reader in Java

## 📌 Topic
`Reader` character data padhne ki abstract class hai. Ye text ke liye hoti hai aur encoding (UTF-8 etc.) khud handle karti hai.

## 🎯 What You Will Learn

- `Reader`, `FileReader`, `StringReader`, `InputStreamReader`
- Character stream aur byte stream me difference
- Encoding ke saath padhna

## 💻 Code

```java
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Reader1 {
    public static void main(String[] args) throws IOException {
        Reader sr = new StringReader("Hello Reader");
        int ch;
        while ((ch = sr.read()) != -1) {
            System.out.print((char) ch);
        }
        System.out.println();

        byte[] data = "Namaste".getBytes(StandardCharsets.UTF_8);
        try (Reader r = new InputStreamReader(new ByteArrayInputStream(data), StandardCharsets.UTF_8)) {
            char[] buf = new char[20];
            int n = r.read(buf);
            System.out.println(new String(buf, 0, n));
        }

        try (BufferedReader br = new BufferedReader(new StringReader("line1\nline2\nline3"))) {
            System.out.println(br.readLine());
            System.out.println(br.lines().count() + " more lines");
        }
    }
}
```

## 🧠 Explanation

### `StringReader`
String ko Reader ki tarah padhta hai.

### `InputStreamReader`
Byte stream ko character stream me badalta hai (bridge), encoding batani padti hai.

### `BufferedReader.lines()`
Baaki lines ka `Stream<String>` deta hai.

## ▶️ Output

```text
Hello Reader
Namaste
line1
2 more lines
```

## 🔑 Important Points

- Reader = characters (16-bit), InputStream = bytes (8-bit).
- Hamesha encoding specify karo (`UTF-8`), warna platform default use hota hai.
- Reader classes bhi `Closeable` hain.

## 📝 Practice

1. `StringReader` se vowels count karo.
2. `InputStreamReader` se console input padho.
3. File ko UTF-8 me padho.
4. `char[]` buffer se padhne ka tarika try karo.

## 🚀 Challenge

`InputStreamReader` aur `BufferedReader` se `System.in` se ek line padho.
