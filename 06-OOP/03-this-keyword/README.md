# this Keyword in Java

## 📌 Topic
`this` current object ka reference hota hai. Iska use fields aur parameters ke naam same hone par confusion hataane ke liye hota hai.

## 🎯 What You Will Learn

- `this` kya hai
- `this.variable` se field access
- `this()` se constructor chaining
- `this` ko method se return karna

## 💻 Code

```java
class Employee {
    String name;
    int salary;

    Employee() {
        this("Unknown", 0);
    }

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    Employee raise(int amount) {
        this.salary += amount;
        return this;
    }

    void show() {
        System.out.println(name + " earns " + salary);
    }
}

public class ThisKeyword {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Rishabh", 30000);

        e1.show();
        e2.raise(5000).raise(2000).show();
    }
}
```

## 🧠 Explanation

### `this.name = name`
Left side ka `this.name` object ka field hai, right side ka `name` parameter hai.

### `this("Unknown", 0)`
Same class ke dusre constructor ko call karta hai (constructor chaining). Ye constructor ki pehli line honi chahiye.

### `return this`
Current object return karta hai, isse method chaining ho paati hai: `e.raise(1).raise(2)`.

## ▶️ Output

```text
Unknown earns 0
Rishabh earns 37000
```

## 🔑 Important Points

- `this` static method ke andar use nahi ho sakta.
- Naam same na ho to `this` zaroori nahi hota.
- `this()` aur `super()` dono constructor ki pehli line par hi aa sakte hain (ek time par ek).

## 📝 Practice

1. Constructor me `this` se fields initialize karo.
2. `this()` se 3 constructors ko chain karo.
3. Method chaining wala `Calculator` banao (`add().sub().show()`).
4. Bina `this` ke same naam ka parameter use karke bug dekho.

## 🚀 Challenge

`Counter` class banao jisme `increment()` `this` return kare, aur `c.increment().increment().increment()` ke baad value print karo.

```text
3
```
