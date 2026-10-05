# Generic Class in Java

## 📌 Topic
Generics se hum aisi class bana sakte hain jo kisi bhi data type ke saath kaam kare, aur compile time par type safety bhi mile.

## 🎯 What You Will Learn

- Generics kyu zaroori hain
- `<T>` type parameter
- Generic class banana aur use karna
- Multiple type parameters (`<K, V>`)

## 💻 Code

```java
class Box<T> {
    private T value;

    Box(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }

    void show() {
        System.out.println("Value: " + value + " (" + value.getClass().getSimpleName() + ")");
    }
}

class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return key + " = " + value;
    }
}

public class GenericClass {
    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>(100);
        Box<String> b2 = new Box<>("Java");
        b1.show();
        b2.show();

        int x = b1.get();
        System.out.println(x + 1);

        Pair<String, Integer> p = new Pair<>("age", 20);
        System.out.println(p);
    }
}
```

## 🧠 Explanation

### `class Box<T>`
`T` ek placeholder hai. Object banate waqt asli type (`Integer`, `String`) tay hota hai.

### `Box<Integer>`
Is box me sirf `Integer` aa sakta hai. `new Box<>("text")` dene par compile error aayega.

### `<K, V>`
Ek se zyada type parameters bhi ho sakte hain (Key, Value).

## ▶️ Output

```text
Value: 100 (Integer)
Value: Java (String)
101
age = 20
```

## 🔑 Important Points

- Generics me primitive (`int`) nahi, wrapper (`Integer`) use hota hai.
- Generics se casting ki zaroorat nahi padti aur `ClassCastException` compile time par hi pakdi jati hai.
- Common names: `T` (Type), `E` (Element), `K` (Key), `V` (Value).
- Runtime par generic type erase ho jata hai (type erasure).

## 📝 Practice

1. `Box<Double>` banao.
2. `Stack<T>` generic class banao.
3. `Pair<String, String>` banao.
4. Galat type dene par compile error dekho.

## 🚀 Challenge

`MyList<T>` generic class banao jisme `add(T)` aur `get(int)` ho (andar array use karo).
