# Reflection in Java

## 📌 Topic
Reflection se program chalte waqt (runtime par) kisi bhi class ke fields, methods aur constructors ki jaankari nikal sakte hain aur unhe use bhi kar sakte hain.

## 🎯 What You Will Learn

- `Class` object nikalna
- Methods, fields aur constructors dekhna
- Reflection se method call karna
- Private field access karna

## 💻 Code

```java
import java.lang.reflect.*;

class Person {
    private String name = "Rishabh";
    public int age = 20;

    public Person() {}

    public void sayHello() {
        System.out.println("Hello, I am " + name);
    }

    private void secret() {
        System.out.println("Secret method");
    }
}

public class Reflection {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Person");
        System.out.println("Class: " + cls.getName());

        for (Field f : cls.getDeclaredFields()) {
            System.out.println("Field: " + f.getName());
        }

        Object obj = cls.getDeclaredConstructor().newInstance();

        Method hello = cls.getMethod("sayHello");
        hello.invoke(obj);

        Method secret = cls.getDeclaredMethod("secret");
        secret.setAccessible(true);
        secret.invoke(obj);

        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj, "Amit");
        hello.invoke(obj);
    }
}
```

## 🧠 Explanation

### `Class.forName("Person")`
Naam (string) se class ka `Class` object deta hai. Dusre tarike: `Person.class`, `obj.getClass()`.

### `getDeclaredFields()`
Saare fields (private bhi) ki list deta hai.

### `method.invoke(obj)`
Method ko runtime par call karta hai.

### `setAccessible(true)`
Private members ko bhi access karne deta hai (encapsulation todta hai, sambhal ke use karo).

## ▶️ Output

```text
Class: Person
Field: name
Field: age
Hello, I am Rishabh
Secret method
Hello, I am Amit
```

## 🔑 Important Points

- Reflection normal code se slow hota hai.
- Spring, Hibernate, JUnit jaise frameworks reflection par hi chalte hain.
- Java 9+ modules me private access par restrictions hain.
- Normal programs me reflection tabhi use karo jab zaroorat ho.

## 📝 Practice

1. Kisi class ke saare methods ke naam print karo.
2. Reflection se object banao.
3. Private field ki value badlo.
4. Class ka parent aur interfaces nikalo.

## 🚀 Challenge

Ek class ke saare `public` methods ko naam se call karne wala chhota test runner banao.
