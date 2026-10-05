# Employee Management System

## 📌 Topic
Console project jisme alag-alag type ke employees (Full-time, Part-time) ki salary polymorphism se calculate hoti hai aur Stream se reports banti hain.

## 🎯 What You Will Learn

- Abstract class aur polymorphism
- `List<Employee>` aur Stream reports
- Department-wise grouping
- Sorting

## 💻 Code

```java
import java.util.*;
import java.util.stream.Collectors;

abstract class Employee {
    final int id;
    final String name;
    final String dept;

    Employee(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    abstract double salary();

    public String toString() {
        return String.format("%-3d %-8s %-6s %9.2f", id, name, dept, salary());
    }
}

class FullTime extends Employee {
    private final double monthly;

    FullTime(int id, String name, String dept, double monthly) {
        super(id, name, dept);
        this.monthly = monthly;
    }

    double salary() { return monthly; }
}

class PartTime extends Employee {
    private final int hours;
    private final double rate;

    PartTime(int id, String name, String dept, int hours, double rate) {
        super(id, name, dept);
        this.hours = hours;
        this.rate = rate;
    }

    double salary() { return hours * rate; }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new FullTime(1, "Rishabh", "IT", 60000));
        list.add(new PartTime(2, "Amit", "HR", 80, 250));
        list.add(new FullTime(3, "Neha", "IT", 75000));
        list.add(new PartTime(4, "Rahul", "Sales", 100, 200));

        list.forEach(System.out::println);

        System.out.println("Total payroll: " + list.stream().mapToDouble(Employee::salary).sum());

        Map<String, Double> byDept = list.stream()
            .collect(Collectors.groupingBy(e -> e.dept, TreeMap::new, Collectors.summingDouble(Employee::salary)));
        System.out.println("By department: " + byDept);

        Employee top = Collections.max(list, Comparator.comparingDouble(Employee::salary));
        System.out.println("Highest paid: " + top.name);

        System.out.println("Sorted by salary:");
        list.stream()
            .sorted(Comparator.comparingDouble(Employee::salary).reversed())
            .forEach(e -> System.out.println("  " + e.name + " " + e.salary()));
    }
}
```

> 💡 Note: Is project me demo ke liye values code me hi di gayi hain taaki output hamesha same aaye. Project ko aage `Scanner` se menu-driven banana tumhara practice task hai.

## 🧠 Explanation

### `abstract double salary()`
Har employee type apni salary alag tarike se nikalta hai: yahi polymorphism hai.

### `FullTime / PartTime`
Full-time ki fixed salary, part-time ki `hours x rate`.

### `groupingBy + summingDouble`
Department-wise total salary ek line me.

## ▶️ Output

```text
1   Rishabh  IT      60000.00
2   Amit     HR      20000.00
3   Neha     IT      75000.00
4   Rahul    Sales   20000.00
Total payroll: 175000.0
By department: {HR=20000.0, IT=135000.0, Sales=20000.0}
Highest paid: Neha
Sorted by salary:
  Neha 75000.0
  Rishabh 60000.0
  Amit 20000.0
  Rahul 20000.0
```

## 🔑 Important Points

- Naya employee type (Intern, Contract) add karo to purana code nahi badalna padta.
- `String.format` se table jaisa output milta hai.
- Tax, bonus aur PF jodkar payroll aur realistic banta hai.

## 📝 Practice

1. `Manager` class jodo jisme bonus ho.
2. Department ke hisab se employees ki list print karo.
3. Employee ko search karo (id se).
4. Salary slip print karne ka method banao.

## 🚀 Challenge

`Intern` employee type banao jisme fixed stipend ho aur payroll report me jodo.
