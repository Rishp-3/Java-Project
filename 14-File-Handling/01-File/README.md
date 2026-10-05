# File Class in Java

## 📌 Topic
`File` class file ya folder ke path ko represent karti hai. Ye file ke andar ka data nahi padhti, balki file ki information aur operations (create, delete, exists) deti hai.

## 🎯 What You Will Learn

- `File` object banana
- `createNewFile()`, `exists()`, `delete()`
- File ka naam, path aur size nikalna
- Folder banana aur list karna

## 💻 Code

```java
import java.io.File;
import java.io.IOException;

public class File1 {
    public static void main(String[] args) throws IOException {
        File f = new File("demo.txt");

        if (f.createNewFile()) {
            System.out.println("File created: " + f.getName());
        } else {
            System.out.println("File already exists");
        }

        System.out.println("Exists: " + f.exists());
        System.out.println("Is file: " + f.isFile());
        System.out.println("Size: " + f.length() + " bytes");
        System.out.println("Can read: " + f.canRead());

        File dir = new File("myFolder");
        System.out.println("Folder created: " + dir.mkdir());

        System.out.println("Deleted: " + f.delete());
        System.out.println("Exists now: " + f.exists());
        dir.delete();
    }
}
```

## 🧠 Explanation

### `new File("demo.txt")`
Sirf object banta hai. Is se asli file nahi banti.

### `createNewFile()`
Asli file banata hai. Pehle se ho to `false` return karta hai.

### `mkdir()`
Folder banata hai. Parent folders bhi banane ho to `mkdirs()` use karo.

### `throws IOException`
File operations me `IOException` aa sakti hai, isliye handle karna zaroori hai.

## ▶️ Output

```text
File created: demo.txt
Exists: true
Is file: true
Size: 0 bytes
Can read: true
Folder created: true
Deleted: true
Exists now: false
```

## 🔑 Important Points

- Relative path program ki working directory se shuru hota hai.
- Windows me path me `\\` ya `/` use karo: `"C:/data/file.txt"`.
- Modern code me `java.nio.file.Files` aur `Path` bhi use hote hain.
- `file.list()` se folder ki files ke naam milte hain.

## 📝 Practice

1. Ek file banao aur uska path print karo.
2. Folder ki saari files list karo.
3. File ka size aur last modified time nikalo.
4. File ko rename karo (`renameTo`).

## 🚀 Challenge

Ek program likho jo check kare ki koi file exist karti hai ya nahi, aur nahi karti to use bana de.
