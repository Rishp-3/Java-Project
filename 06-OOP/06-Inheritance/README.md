# Inheritance in Java

## 📌 Topic
Inheritance me ek class (child) dusri class (parent) ke fields aur methods ko reuse karti hai. `extends` keyword se inheritance hoti hai.

## 🎯 What You Will Learn

- Inheritance kya hai aur kyu use karte hain
- `extends` aur `super` keyword
- Single, Multilevel aur Hierarchical inheritance
- Java me multiple inheritance kyu nahi hai

## 💻 Code

```java
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }

    void bark() {
        System.out.println(name + " is barking");
    }
}

class Puppy extends Dog {
    Puppy(String name) {
        super(name);
    }

    void play() {
        System.out.println(name + " is playing");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Puppy p = new Puppy("Tommy");
        p.eat();
        p.bark();
        p.play();
    }
}
```

## 🧠 Explanation

### `class Dog extends Animal`
`Dog` ko `Animal` ke saare non-private members mil jate hain.

### `super(name)`
Parent class ka constructor call karta hai. Ye child constructor ki pehli line honi chahiye.

### `Multilevel`
`Puppy` -> `Dog` -> `Animal`. Puppy ko dono parents ke methods milte hain.

## ▶️ Output

```text
Tommy is eating
Tommy is barking
Tommy is playing
```

## 🔑 Important Points

- Java me ek class sirf ek class ko extend kar sakti hai (multiple inheritance interfaces se hoti hai).
- Private members inherit nahi hote.
- Sabhi classes ki parent `Object` class hoti hai.
- Constructors inherit nahi hote.

## 📝 Practice

1. `Vehicle` -> `Car` inheritance banao.
2. `Person` -> `Student` aur `Teacher` (hierarchical) banao.
3. `super.method()` se parent ka method call karo.
4. Child object me parent ka constructor call hone ka order dekho.

## 🚀 Challenge

`Shape` -> `Circle`/`Rectangle` hierarchy banao jisme har child ka alag `area()` ho.
