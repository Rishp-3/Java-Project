# InputStream in Java

## 📌 Topic
`InputStream` byte-by-byte data padhne ki abstract class hai. Images, audio, PDF jaise binary files ke liye ye use hoti hai.

## 🎯 What You Will Learn

- Byte stream kya hota hai
- `FileInputStream` se file padhna
- `read()` aur `read(byte[])`
- `ByteArrayInputStream`

## 💻 Code

```java
import java.io.*;

public class Inputstream {
    public static void main(String[] args) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("bytes.dat")) {
            fos.write(new byte[]{72, 101, 108, 108, 111});
        }

        try (InputStream in = new FileInputStream("bytes.dat")) {
            int b;
            while ((b = in.read()) != -1) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

        try (InputStream in = new FileInputStream("bytes.dat")) {
            byte[] buffer = new byte[3];
            int n = in.read(buffer);
            System.out.println("Read " + n + " bytes: " + new String(buffer, 0, n));
        }

        InputStream mem = new ByteArrayInputStream("Java".getBytes());
        System.out.println("Available: " + mem.available());
        new File("bytes.dat").delete();
    }
}
```

## 🧠 Explanation

### `InputStream`
Sabhi input byte streams ki parent class.

### `in.read()`
Ek byte (0-255) `int` me deta hai. End of stream par `-1`.

### `in.read(buffer)`
Ek saath kai bytes buffer me padhta hai aur kitne bytes padhe wo return karta hai.

### `ByteArrayInputStream`
Memory ke byte array ko stream ki tarah padhta hai.

## ▶️ Output

```text
72 101 108 108 111 
Read 3 bytes: Hel
Available: 4
```

## 🔑 Important Points

- Text ke liye `Reader`, binary ke liye `InputStream` use karo.
- Buffer use karne se reading kaafi fast hoti hai.
- Stream hamesha close karo (try-with-resources).
- `BufferedInputStream` se aur speed milti hai.

## 📝 Practice

1. File ke bytes ka sum nikalo.
2. Image file ka size bytes me nikalo.
3. File ko buffer se padh ke print karo.
4. `BufferedInputStream` use karke dekho.

## 🚀 Challenge

Ek file ke saare bytes padhke total byte count print karo.
