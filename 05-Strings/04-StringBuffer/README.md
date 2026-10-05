# StringBuffer in Java

## 📌 Topic
`StringBuffer` bhi `StringBuilder` ki tarah mutable string hai, par ye thread-safe hai (synchronized methods ke kaaran).

## 🎯 What You Will Learn

- StringBuffer kya hai
- `StringBuffer` aur `StringBuilder` me difference
- Kab StringBuffer use karna chahiye

## 💻 Code

```java
public class Stringbuffer {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Java");

        sb.append(" Programming");
        System.out.println(sb);

        sb.insert(0, "Learn ");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        System.out.println("Capacity: " + sb.capacity());
        System.out.println("Length: " + sb.length());
    }
}
```

## 🧠 Explanation

### `StringBuffer`
API `StringBuilder` jaisi hi hai: `append`, `insert`, `delete`, `reverse`.

### `Thread-safe`
Iske methods `synchronized` hain. Ek time par sirf ek thread use badal sakta hai.

### `capacity()`
Internal buffer ki size. Length se alag hoti hai.

## ▶️ Output

```text
Java Programming
Learn Java Programming
gnimmargorP avaJ nraeL
Capacity: 42
Length: 22
```

## 🔑 Important Points

- Single thread me `StringBuilder` fast hai.
- Multiple threads ek hi object badalte hon to `StringBuffer` use karo.
- Teeno me: `String` immutable, `StringBuilder` mutable fast, `StringBuffer` mutable safe.
- `StringBuffer` Java 1.0 se hai, `StringBuilder` Java 5 se.

## 📝 Practice

1. `StringBuffer` me `delete()` aur `replace()` try karo.
2. `StringBuffer` aur `StringBuilder` ka speed test karo.
3. `capacity()` ko `append()` ke baad badalte dekho.
4. `ensureCapacity()` try karo.

## 🚀 Challenge

Teeno classes ka ek table banao (mutable?, thread-safe?, speed) apne notes me.
