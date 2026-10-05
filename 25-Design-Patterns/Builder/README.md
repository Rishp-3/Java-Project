# Builder Pattern in Java

## 📌 Topic
Builder pattern jab object me bahut saare fields hon (kuch optional) tab step-by-step object banane ka saaf tarika hai, bina lambe constructors ke.

## 🎯 What You Will Learn

- Builder pattern kyu chahiye (telescoping constructor problem)
- Static inner `Builder` class
- Method chaining
- Immutable object banana

## 💻 Code

```java
class Pizza {
    private final String size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;

    private Pizza(Builder b) {
        this.size = b.size;
        this.cheese = b.cheese;
        this.pepperoni = b.pepperoni;
        this.mushrooms = b.mushrooms;
    }

    static class Builder {
        private final String size;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;

        Builder(String size) {
            this.size = size;
        }

        Builder cheese() { this.cheese = true; return this; }
        Builder pepperoni() { this.pepperoni = true; return this; }
        Builder mushrooms() { this.mushrooms = true; return this; }

        Pizza build() { return new Pizza(this); }
    }

    public String toString() {
        return size + " pizza [cheese=" + cheese + ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + "]";
    }
}

public class Builder {
    public static void main(String[] args) {
        Pizza p1 = new Pizza.Builder("Large").cheese().pepperoni().build();
        Pizza p2 = new Pizza.Builder("Small").build();

        System.out.println(p1);
        System.out.println(p2);
    }
}
```

## 🧠 Explanation

### `Private constructor`
Bahar se seedha `Pizza` nahi banta, sirf `Builder` se banta hai.

### `Builder(String size)`
Required fields constructor me, optional fields methods me.

### `return this`
Method chaining possible banata hai: `.cheese().pepperoni().build()`.

### `build()`
Final `Pizza` object banata aur return karta hai.

## ▶️ Output

```text
Large pizza [cheese=true, pepperoni=true, mushrooms=false]
Small pizza [cheese=false, pepperoni=false, mushrooms=false]
```

## 🔑 Important Points

- Fields `final` rakho to object immutable ban jata hai.
- Java me examples: `StringBuilder`, `Stream.Builder`; Lombok ka `@Builder`.
- Jab constructor me 4-5 se zyada parameters ho to Builder sochne layak hai.

## 📝 Practice

1. `User` class ka Builder banao (name, email, age, phone).
2. Required aur optional fields alag karo.
3. `build()` me validation lagao.
4. Lombok ka `@Builder` dekho.

## 🚀 Challenge

`Computer` class ka Builder banao (cpu, ram required; ssd, gpu optional).
