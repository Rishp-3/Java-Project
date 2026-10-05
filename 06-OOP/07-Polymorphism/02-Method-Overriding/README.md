# Method Overriding (Runtime Polymorphism)

## 📌 Topic
Jab child class parent class ke method ko apne tarike se dobara likhti hai, use Method Overriding kehte hain. Ye runtime polymorphism hai.

## 🎯 What You Will Learn

- Method Overriding kya hai
- `@Override` annotation
- Parent reference aur child object (upcasting)
- Dynamic method dispatch

## 💻 Code

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Animal a;

        a = new Dog();
        a.sound();

        a = new Cat();
        a.sound();

        Animal[] zoo = { new Dog(), new Cat(), new Animal() };
        for (Animal x : zoo) {
            x.sound();
        }
    }
}
```

## 🧠 Explanation

### `@Override`
Compiler ko batata hai ki ye method parent ka override hai. Naam galat ho to compile error de deta hai.

### `Animal a = new Dog()`
Parent reference se child object. Isse upcasting kehte hain.

### `a.sound()`
Kaun sa version chalega ye object ke asli type (`Dog`/`Cat`) se runtime par decide hota hai.

## ▶️ Output

```text
Dog barks
Cat meows
Dog barks
Cat meows
Animal makes a sound
```

## 🔑 Important Points

- Method ka naam, parameters aur return type same hone chahiye.
- `static`, `final` aur `private` methods override nahi hote.
- Overriding me access level kam nahi kar sakte (public ko private nahi).
- Parent ke version ko `super.sound()` se call kar sakte ho.

## 📝 Practice

1. `Shape` -> `Circle`, `Square` me `area()` override karo.
2. `super.method()` se parent ka version bhi call karo.
3. Array of parent type me different child objects rakho.
4. `final` method override karke error dekho.

## 🚀 Challenge

`Employee` -> `Manager`/`Developer` banao jisme `calculateSalary()` override ho.
