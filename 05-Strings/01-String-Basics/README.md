# String Basics in Java

## 📌 Topic
String characters ka sequence hota hai. Java me `String` ek class hai aur String objects immutable (unchangeable) hote hain.

## 🎯 What You Will Learn

- String banane ke 2 tarike (literal aur `new`)
- String Pool kya hai
- `==` aur `equals()` ka difference
- String immutable kyu hai

## 💻 Code

```java
public class StringBasics {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));

        String name = "Rishabh";
        name.concat(" Kumar");
        System.out.println(name);

        name = name.concat(" Kumar");
        System.out.println(name);
        System.out.println("Length: " + name.length());
    }
}
```

## 🧠 Explanation

### `String s1 = "Java"`
Literal se bana string String Pool me jata hai. Same literal dobara aaye to wahi object reuse hota hai.

### `new String("Java")`
Heap me naya object banata hai, chahe pool me wahi text ho.

### `== vs equals()`
`==` reference (address) compare karta hai, `equals()` content compare karta hai.

### `Immutable`
`concat()` purane string ko nahi badalta, naya string return karta hai. Isliye result ko variable me store karna padta hai.

## ▶️ Output

```text
true
false
true
Rishabh
Rishabh Kumar
Length: 13
```

## 🔑 Important Points

- String comparison ke liye hamesha `equals()` use karo.
- String ek baar ban jaye to badal nahi sakta.
- Bahut baar string badalni ho to `StringBuilder` use karo.
- Index 0 se start hota hai: `"Java".charAt(0)` = `'J'`.

## 📝 Practice

1. Apna naam aur surname concat karke print karo.
2. Do strings `equals()` aur `==` se compare karke difference dekho.
3. String ka pehla aur aakhri character print karo.
4. `equalsIgnoreCase()` try karo.

## 🚀 Challenge

String ko character-by-character alag line me print karo. String: `Java`

```text
J
a
v
a
```
