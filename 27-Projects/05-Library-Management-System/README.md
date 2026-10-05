# Library Management System

## 📌 Topic
Console project jisme books add karna, issue, return, due date aur fine calculate karna shamil hai (`java.time` ke saath).

## 🎯 What You Will Learn

- Date handling (`LocalDate`, `ChronoUnit`)
- Book aur Member ki relation
- Issue/Return logic
- Fine calculation

## 💻 Code

```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Book {
    final int id;
    final String title;
    boolean issued;
    String issuedTo;
    LocalDate dueDate;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }
}

class Library {
    private final Map<Integer, Book> books = new LinkedHashMap<>();
    private static final int LOAN_DAYS = 14;
    private static final int FINE_PER_DAY = 5;

    void addBook(Book b) { books.put(b.id, b); }

    void issue(int id, String member, LocalDate today) {
        Book b = books.get(id);
        if (b == null) { System.out.println("No such book"); return; }
        if (b.issued) { System.out.println(b.title + " is already issued to " + b.issuedTo); return; }
        b.issued = true;
        b.issuedTo = member;
        b.dueDate = today.plusDays(LOAN_DAYS);
        System.out.println(b.title + " issued to " + member + ", due " + b.dueDate);
    }

    void giveBack(int id, LocalDate today) {
        Book b = books.get(id);
        long late = ChronoUnit.DAYS.between(b.dueDate, today);
        long fine = late > 0 ? late * FINE_PER_DAY : 0;
        System.out.println(b.title + " returned by " + b.issuedTo + ". Fine: Rs " + fine);
        b.issued = false;
        b.issuedTo = null;
        b.dueDate = null;
    }

    void available() {
        System.out.print("Available: ");
        for (Book b : books.values()) if (!b.issued) System.out.print(b.title + "; ");
        System.out.println();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook(new Book(1, "Java Basics"));
        lib.addBook(new Book(2, "Data Structures"));
        lib.addBook(new Book(3, "Algorithms"));

        LocalDate start = LocalDate.of(2025, 1, 1);

        lib.issue(1, "Rishabh", start);
        lib.issue(1, "Amit", start);
        lib.available();

        lib.giveBack(1, start.plusDays(20));
        lib.issue(2, "Neha", start);
        lib.giveBack(2, start.plusDays(10));
        lib.available();
    }
}
```

> 💡 Note: Is project me demo ke liye values code me hi di gayi hain taaki output hamesha same aaye. Project ko aage `Scanner` se menu-driven banana tumhara practice task hai.

## 🧠 Explanation

### `LOAN_DAYS / FINE_PER_DAY`
Constants. Rules badalne ho to ek hi jagah badalna padta hai.

### `ChronoUnit.DAYS.between`
Due date aur return date ke beech ke din. Late hone par `din x 5` fine lagta hai.

### `issue()`
Book pehle se issue ho to dobara issue nahi hoti.

## ▶️ Output

```text
Java Basics issued to Rishabh, due 2025-01-15
Java Basics is already issued to Rishabh
Available: Data Structures; Algorithms; 
Java Basics returned by Rishabh. Fine: Rs 30
Data Structures issued to Neha, due 2025-01-15
Data Structures returned by Neha. Fine: Rs 0
Available: Java Basics; Data Structures; Algorithms; 
```

## 🔑 Important Points

- Demo me date fix ki gayi hai (`LocalDate.of`) taaki output hamesha same rahe; asli project me `LocalDate.now()` use hoga.
- Member ko alag `Member` class banana behtar design hai.
- Real library system database ke saath banta hai.

## 📝 Practice

1. `Member` class banao.
2. Ek member ek time me max 3 books issue kar sake.
3. Book search (title se) jodo.
4. Issued books ki report banao.

## 🚀 Challenge

Book ko `ISBN`, `author`, `category` ke saath extend karo aur category-wise report print karo.
