# Serialization in Java

## 📌 Topic
Serialization object ko bytes me convert karne ki process hai taaki use file me save kiya ja sake ya network par bheja ja sake.

## 🎯 What You Will Learn

- Serialization kya hai
- `Serializable` interface
- `ObjectOutputStream` se object save karna
- `transient` keyword

## 💻 Code

```java
import java.io.*;

class User implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int age;
    transient String password;

    User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}

public class Serialization {
    public static void main(String[] args) throws IOException {
        User u = new User("Rishabh", 20, "secret123");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            out.writeObject(u);
        }

        System.out.println("Object serialized");
        System.out.println("File size > 0: " + (new File("user.ser").length() > 0));
        new File("user.ser").delete();
    }
}
```

## 🧠 Explanation

### `implements Serializable`
Marker interface (isme koi method nahi). Ye batata hai ki is class ke objects serialize ho sakte hain.

### `ObjectOutputStream.writeObject()`
Object ko bytes me badalke stream me likhta hai.

### `transient`
Is field ko serialization me shamil nahi kiya jata (password jaise sensitive data ke liye).

### `serialVersionUID`
Class ka version number. Deserialize karte waqt class match ho ye check hota hai.

## ▶️ Output

```text
Object serialized
File size > 0: true
```

## 🔑 Important Points

- Object ke saare fields bhi `Serializable` hone chahiye, warna `NotSerializableException` aati hai.
- `static` fields serialize nahi hote.
- Parent class `Serializable` ho to child automatically serializable hoti hai.
- Untrusted data deserialize karna security risk hai.

## 📝 Practice

1. `Student` object serialize karke file me save karo.
2. `transient` field ke saath test karo.
3. ArrayList of objects serialize karo.
4. Non-serializable class serialize karke exception dekho.

## 🚀 Challenge

`ArrayList<User>` ko ek hi file me serialize karo.
