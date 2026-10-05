# Method Overloading (Compile-time Polymorphism)

## 📌 Topic
Polymorphism ka matlab hai 'ek naam, kai roop'. Method Overloading compile-time polymorphism hai jisme same naam ke methods parameters se alag hote hain.

## 🎯 What You Will Learn

- Polymorphism ka matlab
- Compile-time polymorphism
- Overloading ke rules
- Class ke andar overloaded methods

## 💻 Code

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    String add(String a, String b) {
        return a + b;
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(5, 10));
        System.out.println(c.add(2.5, 4.5));
        System.out.println(c.add(1, 2, 3));
        System.out.println(c.add("Java", "Script"));
    }
}
```

## 🧠 Explanation

### `Same naam`
Sabhi methods ka naam `add` hai.

### `Alag signature`
Parameters ki sankhya ya type alag hone se compiler sahi method chun leta hai.

### `Compile-time`
Kaun sa method chalega ye program chalne se pehle compile time par hi tay ho jata hai.

## ▶️ Output

```text
15
7.0
6
JavaScript
```

## 🔑 Important Points

- Return type alag hone se overloading nahi hoti.
- Access modifier alag hone se bhi overloading nahi hoti.
- Overloading ek hi class (ya inheritance) me hoti hai.

## 📝 Practice

1. `area()` overload karo: square, rectangle, circle.
2. `print()` overload karo: int, String, double.
3. Constructor overloading bhi try karo.
4. `null` pass karke ambiguity samjho.

## 🚀 Challenge

`Printer` class banao jisme `print(int)`, `print(String)`, `print(double[])` methods hon.
