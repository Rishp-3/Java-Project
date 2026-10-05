# Comments in Java

## 📌 Topic
Comments wo lines hoti hain jo compiler ignore karta hai. Inka use code ko explain karne aur code ko temporarily disable karne ke liye hota hai.

## 🎯 What You Will Learn

- Single-line comment `//`
- Multi-line comment `/* */`
- Documentation comment `/** */` (Javadoc)
- Code ko temporarily disable karna

## 💻 Code

```java
/**
 * Java Comments Practice
 */
public class Comments {

    public static void main(String[] args) {

        // ==============================
        // 1. Single-Line Comment
        // ==============================

        // This is a single-line comment
        System.out.println("Hello Java");


        // ==============================
        // 2. Comment After Code
        // ==============================

        int age = 20; // Student age
        System.out.println("Age: " + age);


        // ==============================
        // 3. Multi-Line Comment
        // ==============================

        /*
         * This is a multi-line comment.
         * It can contain multiple lines.
         */

        System.out.println("Multi-line comment example");


        // ==============================
        // 4. Documentation Comment
        // ==============================

        /**
         * Documentation comments are
         * used for Javadoc documentation.
         */

        System.out.println("Documentation comment example");


        // ==============================
        // 5. Temporarily Disable Code
        // ==============================

        // System.out.println("This line is disabled");

        System.out.println("This line is active");


        // ==============================
        // 6. Practice
        // ==============================

        String name = "Rishabh";
        int marks = 85;

        // Check whether student passed
        boolean passed = marks >= 40;

        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Passed: " + passed);
    }
}
```

## 🧠 Explanation

### `// comment`
Ek line ka comment. `//` ke baad ki poori line ignore hoti hai.

### `/* ... */`
Multiple lines ka comment. Beech ka poora text ignore hota hai.

### `/** ... */`
Javadoc comment. Isse `javadoc` tool se documentation HTML ban sakti hai.

## ▶️ Output

```text
Hello Java
Age: 20
Multi-line comment example
Documentation comment example
This line is active
Name: Rishabh
Marks: 85
Passed: true
```

## 🔑 Important Points

- Comments program ke output ko affect nahi karte.
- Multi-line comments ke andar multi-line comment nest nahi kar sakte.
- Achha comment batata hai *kyu* kiya, sirf *kya* nahi.
- Zyada comments se behtar hai clear variable aur method names.

## 📝 Practice

1. Apne purane program me har step par comment likho.
2. Ek `println` line ko comment karke output dekho.
3. Ek class par Javadoc comment likho.
4. Ek program likho jisme teeno type ke comments hon.

## 🚀 Challenge

Ek program likho jisme 5 lines ka code ho, aur har line ke upar uska explanation comment me likho.
