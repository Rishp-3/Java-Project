# Singleton Pattern in Java

## 📌 Topic
Singleton pattern ensure karta hai ki ek class ka sirf ek hi object bane aur poore program me wahi share ho.

## 🎯 What You Will Learn

- Singleton kya hai aur kab use karte hain
- Private constructor aur static instance
- Thread-safe Singleton
- Enum Singleton

## 💻 Code

```java
class Config {
    private static Config instance;

    private Config() {
        System.out.println("Config object created");
    }

    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    String appName = "MyApp";
}

enum Logger {
    INSTANCE;

    void log(String msg) {
        System.out.println("[LOG] " + msg);
    }
}

public class Singleton {
    public static void main(String[] args) {
        Config a = Config.getInstance();
        Config b = Config.getInstance();

        System.out.println(a == b);
        a.appName = "Changed";
        System.out.println(b.appName);

        Logger.INSTANCE.log("Hello");
        Logger.INSTANCE.log("Only one logger exists");
    }
}
```

## 🧠 Explanation

### `private Config()`
Private constructor se bahar koi `new Config()` nahi kar sakta.

### `getInstance()`
Pehli baar object banata hai, baad me wahi object return karta hai. `synchronized` se multi-thread me safe rehta hai.

### `enum Logger`
Enum se Singleton sabse safe aur simple tarika hai (serialization aur reflection se bhi safe).

## ▶️ Output

```text
Config object created
true
Changed
[LOG] Hello
[LOG] Only one logger exists
```

## 🔑 Important Points

- Use cases: Logger, Configuration, Database connection pool, Cache.
- Zyada Singleton use karne se testing mushkil ho jati hai (global state).
- Double-checked locking me `volatile` keyword zaroori hai.
- Multi-thread me simple `if (instance == null)` unsafe hai.

## 📝 Practice

1. `DatabaseConnection` Singleton banao.
2. Double-checked locking wala version likho.
3. Enum Singleton banao.
4. `a == b` se verify karo ki dono same object hain.

## 🚀 Challenge

`Counter` Singleton banao jo har jagah se `increment()` hone par ek hi count rakhe.
