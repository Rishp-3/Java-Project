# Factory Pattern in Java

## 📌 Topic
Factory pattern me object banane ka kaam ek alag class (factory) karti hai. Isse caller ko ye nahi jaanna padta ki kaun si class ka object ban raha hai.

## 🎯 What You Will Learn

- Factory pattern kya hai
- Interface + multiple implementations
- Factory method se object return karna
- `new` ko ek jagah rakhne ke fayde

## 💻 Code

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() { System.out.println("Drawing Circle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("Drawing Square"); }
}

class Triangle implements Shape {
    public void draw() { System.out.println("Drawing Triangle"); }
}

class ShapeFactory {
    static Shape create(String type) {
        switch (type.toLowerCase()) {
            case "circle":   return new Circle();
            case "square":   return new Square();
            case "triangle": return new Triangle();
            default: throw new IllegalArgumentException("Unknown shape: " + type);
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        String[] requests = {"circle", "square", "triangle"};
        for (String r : requests) {
            Shape s = ShapeFactory.create(r);
            s.draw();
        }

        try {
            ShapeFactory.create("hexagon");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

## 🧠 Explanation

### `interface Shape`
Common type. Caller sirf `Shape` jaanta hai.

### `ShapeFactory.create()`
String ke hisab se sahi class ka object banake return karta hai.

### `Fayda`
Naya shape add karna ho to sirf nayi class aur factory me ek case jodna hai. Baaki code same rehta hai.

## ▶️ Output

```text
Drawing Circle
Drawing Square
Drawing Triangle
Unknown shape: hexagon
```

## 🔑 Important Points

- Java me examples: `Calendar.getInstance()`, `NumberFormat.getInstance()`, `List.of()`.
- Factory object creation ko caller se alag (loosely coupled) rakhta hai.
- Bade systems me Abstract Factory aur Factory Method bhi use hote hain.

## 📝 Practice

1. `Vehicle` factory banao (Car, Bike, Truck).
2. `Notification` factory banao (Email, SMS, Push).
3. Enum se type pass karo (string ki jagah).
4. Factory me naya type jodo.

## 🚀 Challenge

`PaymentFactory` banao jo `upi`, `card`, `cash` ke liye alag `Payment` object de.
