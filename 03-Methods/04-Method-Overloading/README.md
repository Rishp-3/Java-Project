# Method Overloading in Java

## 📌 Topic
Same naam ke multiple methods jinke parameters alag hon, use Method Overloading kehte hain. Ye compile-time polymorphism hai.

## 🎯 What You Will Learn

- Method Overloading kya hai
- Parameters ki sankhya aur type se overloading
- Return type se overloading kyu nahi hoti

## 💻 Code

```java
public class MethodOverloading {

    static int add(int a, int b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        System.out.println(add(10, 20));
        System.out.println(add(10, 20, 30));
        System.out.println(add(2.5, 3.5));
    }
}
```

## 🧠 Explanation

### `add(int a, int b)`
Do `int` parameters wala version.

### `add(int a, int b, int c)`
Parameters ki sankhya alag hai, isliye ye alag method maana jata hai.

### `add(double a, double b)`
Parameter type alag hai, isliye ye bhi valid overload hai.

## ▶️ Output

```text
30
60
6.0
```

## 🔑 Important Points

- Overloading ke liye parameters ki sankhya, type ya order alag hona chahiye.
- Sirf return type alag karne se overloading nahi hoti (compile error).
- Kaun sa method chalega ye compile time par decide hota hai.
- `System.out.println()` khud overloaded method hai.

## 📝 Practice

1. `area()` method overload karo: circle (radius) aur rectangle (length, width) ke liye.
2. `max()` method 2 aur 3 numbers ke liye banao.
3. `print(int)`, `print(String)`, `print(double)` banao.
4. Order change karke overload banao: `show(int, String)` aur `show(String, int)`.

## 🚀 Challenge

`multiply()` ke 3 versions banao: 2 ints, 3 ints aur 2 doubles. Teeno call karke output print karo.
