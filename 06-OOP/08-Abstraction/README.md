# Abstraction in Java

## 📌 Topic
Abstraction me sirf zaroori cheezein dikhayi jati hain aur implementation details chhupayi jati hain. Java me ye `abstract class` aur `interface` se hota hai.

## 🎯 What You Will Learn

- Abstraction kya hai
- `abstract` class aur `abstract` method
- Concrete method abstract class me
- Abstract class ka object kyu nahi banta

## 💻 Code

```java
abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    abstract double area();

    void showColor() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    double r;

    Circle(String color, double r) {
        super(color);
        this.r = r;
    }

    double area() {
        return Math.PI * r * r;
    }
}

class Rectangle extends Shape {
    double l, w;

    Rectangle(String color, double l, double w) {
        super(color);
        this.l = l;
        this.w = w;
    }

    double area() {
        return l * w;
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Shape c = new Circle("Red", 3);
        Shape r = new Rectangle("Blue", 4, 5);

        c.showColor();
        System.out.printf("Area: %.2f%n", c.area());
        r.showColor();
        System.out.println("Area: " + r.area());
    }
}
```

## 🧠 Explanation

### `abstract class Shape`
Aisi class jiska direct object nahi ban sakta. Ye sirf parent ke roop me use hoti hai.

### `abstract double area();`
Sirf declaration, body nahi. Har child class ko ise implement karna zaroori hai.

### `void showColor()`
Abstract class me normal (concrete) methods bhi ho sakte hain.

## ▶️ Output

```text
Color: Red
Area: 28.27
Color: Blue
Area: 20.0
```

## 🔑 Important Points

- Abstract class me constructor, fields aur normal methods bhi ho sakte hain.
- Child class sabhi abstract methods implement na kare to wo bhi `abstract` honi chahiye.
- `abstract` aur `final` ek saath nahi aa sakte.
- 100% abstraction ke liye interface use hota hai.

## 📝 Practice

1. `Vehicle` abstract class banao jisme `start()` abstract ho.
2. `Employee` abstract class me `salary()` abstract rakho.
3. Abstract class ka object banane ki koshish karke error dekho.
4. Abstract class me constructor likh ke child se call karo.

## 🚀 Challenge

`Bank` abstract class banao jisme `getInterestRate()` abstract ho. `SBI` (6%), `HDFC` (7%), `ICICI` (7.5%) banao.
