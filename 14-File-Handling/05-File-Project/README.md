# File Handling Mini Project

## 📌 Topic
Is mini project me ek Contact Book banayi hai jo contacts ko file me save karti hai aur program dobara chalne par wapas load karti hai.

## 🎯 What You Will Learn

- Data ko file me permanently save karna
- File se data load karna
- `ArrayList` ke saath file handling
- Search aur display

## 💻 Code

```java
import java.io.*;
import java.util.*;

public class FileProject {

    static final String FILE = "contacts.txt";

    static void save(List<String> contacts) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (String c : contacts) pw.println(c);
        }
    }

    static List<String> load() throws IOException {
        List<String> list = new ArrayList<>();
        File f = new File(FILE);
        if (!f.exists()) return list;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) list.add(line);
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        List<String> contacts = load();
        System.out.println("Loaded: " + contacts.size());

        contacts.add("Rishabh:9876543210");
        contacts.add("Amit:9123456780");
        save(contacts);

        List<String> again = load();
        System.out.println("After reload: " + again.size());
        for (String c : again) {
            String[] p = c.split(":");
            System.out.println(p[0] + " -> " + p[1]);
        }

        for (String c : again) {
            if (c.startsWith("Amit")) System.out.println("Found: " + c);
        }
        new File(FILE).delete();
    }
}
```

## 🧠 Explanation

### `save()`
Saari list file me line-by-line likhta hai. `PrintWriter.println()` aasan hai.

### `load()`
File na ho to khali list return karta hai, hai to lines padh ke list banata hai.

### `Persistence`
Program band hone ke baad bhi data file me bacha rehta hai.

## ▶️ Output

```text
Loaded: 0
After reload: 2
Rishabh -> 9876543210
Amit -> 9123456780
Found: Amit:9123456780
```

## 🔑 Important Points

- Real projects me data format (CSV/JSON) pehle tay kar lo.
- File ko padhne se pehle `exists()` check karo.
- Delimiter (`:` ya `,`) data me nahi hona chahiye warna split galat hoga.

## 📝 Practice

1. Contact delete karne ka option jodo.
2. Contacts ko alphabetically sort karo.
3. `Scanner` se menu banao.
4. CSV format me save karo.

## 🚀 Challenge

Project me ek `Contact` class banao aur `Serializable` se `.ser` file me save karo (Serialization topic ke baad).
