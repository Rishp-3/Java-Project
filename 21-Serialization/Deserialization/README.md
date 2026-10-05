# Deserialization in Java

## 📌 Topic
Deserialization bytes (file/network) se wapas object banane ki process hai. Ye Serialization ka ulta hai.

## 🎯 What You Will Learn

- Deserialization kya hai
- `ObjectInputStream.readObject()`
- `transient` field ki value kya milti hai
- `ClassNotFoundException`

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

public class Deserialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User original = new User("Rishabh", 20, "secret123");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            out.writeObject(original);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"))) {
            User restored = (User) in.readObject();
            System.out.println("Name: " + restored.name);
            System.out.println("Age: " + restored.age);
            System.out.println("Password: " + restored.password);
        }
        new File("user.ser").delete();
    }
}
```

## 🧠 Explanation

### `readObject()`
Stream se bytes padhkar object banata hai. Return type `Object` hota hai, isliye cast karna padta hai.

### `Password: null`
`transient` field save nahi hui thi, isliye deserialize hone par uski default value (`null`) milti hai.

### `Constructor`
Deserialization me `Serializable` class ka constructor call nahi hota.

## ▶️ Output

```text
Name: Rishabh
Age: 20
Password: null
```

## 🔑 Important Points

- Class ka `serialVersionUID` badalne par `InvalidClassException` aati hai.
- `readObject()` `IOException` aur `ClassNotFoundException` dono throw karta hai.
- Zyada safe aur portable formats ke liye JSON (Jackson/Gson) bhi use hote hain.

## 📝 Practice

1. Serialize kiya hua object file se wapas padho.
2. List of objects deserialize karo.
3. `serialVersionUID` badal ke exception dekho.
4. `transient` field ko custom `readObject` se handle karo.

## 🚀 Challenge

Ek chhota address book banao jo contacts ko `.ser` file me save aur load kare.
