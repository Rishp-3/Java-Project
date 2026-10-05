# OutputStream in Java

## 📌 Topic
`OutputStream` byte-by-byte data likhne ki abstract class hai. Binary data (image, audio, file copy) likhne ke liye use hoti hai.

## 🎯 What You Will Learn

- `FileOutputStream` se bytes likhna
- `write(int)` aur `write(byte[])`
- File copy karna
- `ByteArrayOutputStream`

## 💻 Code

```java
import java.io.*;

public class Outputstream {
    public static void main(String[] args) throws IOException {
        try (OutputStream out = new FileOutputStream("source.bin")) {
            out.write(65);
            out.write("BCD".getBytes());
        }

        try (InputStream in = new FileInputStream("source.bin");
             OutputStream out = new FileOutputStream("copy.bin")) {
            byte[] buf = new byte[1024];
            int n;
            while ((n = in.read(buf)) != -1) {
                out.write(buf, 0, n);
            }
        }
        System.out.println("Copied size: " + new File("copy.bin").length());

        try (InputStream in = new FileInputStream("copy.bin")) {
            System.out.println(new String(in.readAllBytes()));
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write("Memory".getBytes());
        System.out.println(bos.toString());

        new File("source.bin").delete();
        new File("copy.bin").delete();
    }
}
```

## 🧠 Explanation

### `out.write(65)`
Ek byte likhta hai (`65` ASCII me `A`).

### `out.write(buf, 0, n)`
Buffer ke pehle `n` bytes likhta hai.

### `Copy loop`
`in.read(buf)` se padhte jao aur `out.write()` se likhte jao jab tak `-1` na mile.

## ▶️ Output

```text
Copied size: 4
ABCD
Memory
```

## 🔑 Important Points

- FileOutputStream default me overwrite karta hai, append ke liye `new FileOutputStream(name, true)`.
- `flush()` buffered data ko bhej deta hai, `close()` khud flush karta hai.
- Text likhna ho to `Writer` behtar hai.

## 📝 Practice

1. Ek file ko dusri file me copy karo.
2. Bytes array ko file me likho.
3. File copy hone ka time naapo.
4. `BufferedOutputStream` use karo.

## 🚀 Challenge

Image file ko ek naye naam se copy karo.
