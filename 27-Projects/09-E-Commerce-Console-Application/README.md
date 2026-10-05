# E-Commerce Console Application

## 📌 Topic
Mini e-commerce app jisme products ka catalog, shopping cart, discount, tax aur bill generation hota hai.

## 🎯 What You Will Learn

- Product, CartItem aur Cart classes
- `Map` se cart quantity manage karna
- Discount (Strategy) aur GST
- Bill print karna

## 💻 Code

```java
import java.util.*;

class Product {
    final int id;
    final String name;
    final double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

interface Discount {
    double apply(double total);
}

class Cart {
    private final Map<Product, Integer> items = new LinkedHashMap<>();

    void add(Product p, int qty) {
        items.merge(p, qty, Integer::sum);
    }

    void remove(Product p) {
        items.remove(p);
    }

    double subtotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            total += e.getKey().price * e.getValue();
        }
        return total;
    }

    void printBill(Discount discount) {
        System.out.println("------------ BILL ------------");
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            Product p = e.getKey();
            int q = e.getValue();
            System.out.printf("%-10s x%d  %9.2f%n", p.name, q, p.price * q);
        }
        double sub = subtotal();
        double afterDiscount = discount.apply(sub);
        double gst = afterDiscount * 0.18;
        System.out.printf("Subtotal:   %10.2f%n", sub);
        System.out.printf("Discount:  -%10.2f%n", sub - afterDiscount);
        System.out.printf("GST (18%%):  %10.2f%n", gst);
        System.out.printf("TOTAL:      %10.2f%n", afterDiscount + gst);
    }
}

public class ECommerceConsoleApplication {
    public static void main(String[] args) {
        Product laptop = new Product(1, "Laptop", 50000);
        Product mouse = new Product(2, "Mouse", 500);
        Product book = new Product(3, "Java Book", 800);

        Cart cart = new Cart();
        cart.add(laptop, 1);
        cart.add(mouse, 2);
        cart.add(book, 1);
        cart.add(mouse, 1);

        Discount tenPercent = total -> total * 0.90;
        Discount none = total -> total;

        cart.printBill(tenPercent);

        cart.remove(laptop);
        System.out.println();
        cart.printBill(none);
    }
}
```

> 💡 Note: Is project me demo ke liye values code me hi di gayi hain taaki output hamesha same aaye. Project ko aage `Scanner` se menu-driven banana tumhara practice task hai.

## 🧠 Explanation

### `Cart`
`Map<Product, Integer>` me product aur uski quantity. `merge()` same product dubara add karne par quantity jod deta hai.

### `Discount interface`
Strategy pattern: alag discount rules ko lambda se de sakte ho.

### `printBill()`
`printf` se aligned table. Subtotal, discount, GST aur final total dikhata hai.

## ▶️ Output

```text
------------ BILL ------------
Laptop     x1   50000.00
Mouse      x3    1500.00
Java Book  x1     800.00
Subtotal:     52300.00
Discount:  -   5230.00
GST (18%):     8472.60
TOTAL:        55542.60

------------ BILL ------------
Mouse      x3    1500.00
Java Book  x1     800.00
Subtotal:      2300.00
Discount:  -      0.00
GST (18%):      414.00
TOTAL:         2714.00
```

## 🔑 Important Points

- Real systems me paise ke liye `BigDecimal` use hota hai.
- `Product` ko `Map` key banane ke liye `equals()`/`hashCode()` (ya same object reference) zaroori hai.
- Stock management, user login aur orders ka database next steps hain.

## 📝 Practice

1. Stock quantity jodo aur out-of-stock par error do.
2. Coupon code system banao.
3. Product search (naam se) jodo.
4. Order history rakho.

## 🚀 Challenge

Is project ko `Scanner` se menu-driven banao: catalog dekho, cart me add karo, checkout karo.
