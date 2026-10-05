# Interface in Java

## 📌 Topic
Interface ek contract hota hai jisme sirf batate hain ki kya karna hai, kaise karna hai ye implementing class tay karti hai. Isse Java me multiple inheritance milti hai.

## 🎯 What You Will Learn

- Interface banana aur `implements` karna
- Ek class me multiple interfaces
- `default` aur `static` methods
- Interface vs Abstract class

## 💻 Code

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();

    default void info() {
        System.out.println("I can swim");
    }
}

class Duck implements Flyable, Swimmable {
    public void fly() {
        System.out.println("Duck flies");
    }

    public void swim() {
        System.out.println("Duck swims");
    }
}

public class Interface {
    public static void main(String[] args) {
        Duck d = new Duck();
        d.fly();
        d.swim();
        d.info();

        Flyable f = d;
        f.fly();
    }
}
```

## 🧠 Explanation

### `interface Flyable`
Isme methods by default `public abstract` hote hain aur variables `public static final`.

### `implements Flyable, Swimmable`
Ek class kai interfaces implement kar sakti hai.

### `default void info()`
Java 8 se interface me body wale `default` methods aa sakte hain.

### `public void fly()`
Implement karte waqt method `public` hona zaroori hai.

## ▶️ Output

```text
Duck flies
Duck swims
I can swim
Duck flies
```

## 🔑 Important Points

- Interface ka object nahi banta, par uska reference ban sakta hai.
- Interface `extends` se doosre interfaces ko extend kar sakta hai.
- Abstract class me state (fields) ho sakti hai, interface me nahi.
- Functional interface (ek abstract method) lambda ke liye use hota hai.

## 📝 Practice

1. `Playable` interface banao aur `Guitar`, `Piano` implement karo.
2. Do interfaces ek class me implement karo.
3. Interface me `static` method banao.
4. Interface constants banao aur access karo.

## 🚀 Challenge

`Payment` interface banao aur `UPI`, `Card` classes implement karo. Interface type ke array se `pay()` call karo.
