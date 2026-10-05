# Packages in Java

## 📌 Topic
Package related classes ka ek group (folder) hota hai. Isse code organize rehta hai aur naam ke conflict se bachte hain.

## 🎯 What You Will Learn

- Package kya hota hai
- `package` statement ka use
- Package ka folder structure
- Package ke saath program compile aur run karna

## 💻 Code

```java
// File: com/rishabh/util/Calculator.java
package com.rishabh.util;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

// File: Main.java
import com.rishabh.util.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println("Sum = " + c.add(10, 20));
    }
}
```

> 💡 Note: Ye example 2 alag files me hai. Pehli file `com/rishabh/util/` folder me aur doosri file project ke root me rakho.

## 🧠 Explanation

### `package com.rishabh.util;`
Ye line file ki sabse pehli statement hoti hai aur batati hai ki class kis package me hai.

### `Folder structure`
Package ka naam folder structure se match hona chahiye: `com/rishabh/util/Calculator.java`.

### `import`
Dusre package ki class use karne ke liye import karte hain.

## ▶️ Output

```text
Sum = 30
```

## 🔑 Important Points

- Package naam aam taur par lowercase me hota hai.
- Company domain ulta likhne ki convention hai: `com.company.project`.
- Built-in packages: `java.lang` (auto-import), `java.util`, `java.io`.
- Ek file me sirf ek `package` statement ho sakti hai.

## 📝 Practice

1. `com.myapp.model` package banao aur usme `Student` class rakho.
2. Do packages banao aur ek class dusre me use karo.
3. `javap` ya IDE se package structure dekho.
4. Command line se compile karo.

## 🚀 Challenge

Compile aur run command likho:

`javac -d out com/rishabh/util/Calculator.java Main.java`

`java -cp out Main`

In commands ko khud chalake dekho.
