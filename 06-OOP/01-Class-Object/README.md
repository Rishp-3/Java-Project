# Class and Object in Java

## 📌 Topic
Class ek blueprint (naksha) hoti hai aur Object us blueprint se bana real instance hota hai. OOP ka sabse pehla concept yehi hai.

## 🎯 What You Will Learn

- Class aur Object kya hote hain
- Fields (variables) aur methods
- `new` keyword se object banana
- Ek class ke multiple objects

## 💻 Code

```java
class Student {
    String name;
    int age;

    void display() {
        System.out.println(name + " - " + age);
    }
}

public class ClassObject {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Rishabh";
        s1.age = 20;

        Student s2 = new Student();
        s2.name = "Amit";
        s2.age = 22;

        s1.display();
        s2.display();
    }
}
```

## 🧠 Explanation

### `class Student`
Blueprint jisme data (`name`, `age`) aur behaviour (`display()`) define hota hai.

### `new Student()`
Memory me naya object banata hai aur uska reference return karta hai.

### `s1.name`
Dot operator se object ke field ya method ko access karte hain.

## ▶️ Output

```text
Rishabh - 20
Amit - 22
```

## 🔑 Important Points

- Class sirf template hai, memory object banne par milti hai.
- Har object ke fields ki apni alag copy hoti hai.
- Class ka naam capital letter se start karte hain.
- Ek `.java` file me multiple classes ho sakti hain par `public` sirf ek.

## 📝 Practice

1. `Car` class banao (brand, price) aur 3 objects banao.
2. `Rectangle` class banao jo area return kare.
3. Object banake uske fields ki default values print karo.
4. Ek object ko dusre variable me assign karke reference concept samjho.

## 🚀 Challenge

`BankAccount` class banao (accountNo, balance) aur 2 objects ki details print karo.
