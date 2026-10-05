# Access Modifiers in Java

## 📌 Topic
Access modifiers decide karte hain ki class, variable ya method ko kahan se access kiya ja sakta hai.

## 🎯 What You Will Learn

- `private`, default, `protected`, `public`
- Har modifier ki visibility
- Encapsulation me inka role

## 💻 Code

```java
class Demo {
    public String pub = "public";
    protected String pro = "protected";
    String def = "default";
    private String pri = "private";

    String getPrivate() {
        return pri;
    }
}

public class AccessModifiers {
    public static void main(String[] args) {
        Demo d = new Demo();

        System.out.println(d.pub);
        System.out.println(d.pro);
        System.out.println(d.def);
        // System.out.println(d.pri);   // Error: private
        System.out.println(d.getPrivate());
    }
}
```

## 🧠 Explanation

### `private`
Sirf usi class ke andar access hota hai.

### `default (kuch nahi likhna)`
Same package ke andar access hota hai.

### `protected`
Same package me, aur dusre package ki child class me bhi access hota hai.

### `public`
Kahin se bhi access ho sakta hai.

## ▶️ Output

```text
public
protected
default
private
```

## 🔑 Important Points

- Visibility: `private` < default < `protected` < `public`.
- Fields ko hamesha jitna ho sake `private` rakho.
- Top-level class sirf `public` ya default ho sakti hai.
- Same file me hone se private access nahi milta (different class).

## 📝 Practice

1. `private` field access karke error dekho.
2. Ek package me do classes banao aur default access test karo.
3. Dusre package se `protected` member child class me use karo.
4. Neeche ka table apni copy me bharo: modifier x (same class, same package, child, anywhere).

## 🚀 Challenge

Ek table banao jisme 4 modifiers aur 4 scopes (same class, same package, subclass in other package, world) ke liye Yes/No likho.
