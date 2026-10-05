# Constructor in Java

## 📌 Topic
Constructor ek special method hai jo object banate waqt automatically call hota hai aur object ko initialize karta hai.

## 🎯 What You Will Learn

- Constructor kya hai aur uske rules
- Default aur Parameterized constructor
- Constructor Overloading
- Constructor aur method me difference

## 💻 Code

```java
class Student {
    String name;
    int age;

    Student() {
        name = "Unknown";
        age = 0;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println(name + " - " + age);
    }
}

public class Constructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Rishabh", 20);
        s1.display();
        s2.display();
    }
}
```

## 🧠 Explanation

### `Student()`
Default (no-arg) constructor. Bina arguments ke object banane par chalta hai.

### `Student(String name, int age)`
Parameterized constructor. Object banate hi values set kar deta hai.

### `Constructor Overloading`
Same class me multiple constructors, bas parameters alag hon.

## ▶️ Output

```text
Unknown - 0
Rishabh - 20
```

## 🔑 Important Points

- Constructor ka naam class ke naam jaisa hota hai.
- Constructor ka return type nahi hota (`void` bhi nahi).
- Agar tum koi constructor nahi likhte, Java default constructor khud bana deta hai.
- Tum parameterized constructor likhoge to Java default constructor nahi banata.

## 📝 Practice

1. `Car` class me parameterized constructor banao.
2. Teen constructors banao: 0, 1 aur 2 parameters ke.
3. Constructor ke andar print likh ke dekho kab call hota hai.
4. Copy constructor banao.

## 🚀 Challenge

`Book` class banao (title, author, price) with default aur parameterized constructor. 2 books print karo.
