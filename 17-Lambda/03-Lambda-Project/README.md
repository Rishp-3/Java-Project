# Lambda Mini Project

## 📌 Topic
Is mini project me ek simple Employee Filter system banaya hai jisme lambda aur functional interface se alag-alag conditions (rules) pass ki jati hain.

## 🎯 What You Will Learn

- Behaviour ko parameter ki tarah pass karna
- Custom functional interface ka real use
- Filtering, sorting aur action ko lambda se karna

## 💻 Code

```java
import java.util.*;

class Employee {
    String name;
    String dept;
    double salary;

    Employee(String name, String dept, double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String toString() {
        return name + " (" + dept + ", " + salary + ")";
    }
}

interface Rule {
    boolean test(Employee e);
}

public class LambdaProject {

    static List<Employee> filter(List<Employee> list, Rule rule) {
        List<Employee> out = new ArrayList<>();
        for (Employee e : list) {
            if (rule.test(e)) out.add(e);
        }
        return out;
    }

    public static void main(String[] args) {
        List<Employee> emps = List.of(
            new Employee("Rishabh", "IT", 60000),
            new Employee("Amit", "HR", 40000),
            new Employee("Neha", "IT", 80000),
            new Employee("Rahul", "Sales", 35000)
        );

        System.out.println("IT employees:");
        filter(emps, e -> e.dept.equals("IT")).forEach(System.out::println);

        System.out.println("Salary > 50000:");
        filter(emps, e -> e.salary > 50000).forEach(System.out::println);

        List<Employee> sorted = new ArrayList<>(emps);
        sorted.sort((a, b) -> Double.compare(b.salary, a.salary));
        System.out.println("Highest paid: " + sorted.get(0));
    }
}
```

## 🧠 Explanation

### `interface Rule`
Functional interface jo batata hai ki employee ko select karna hai ya nahi.

### `filter(list, rule)`
Ek hi method alag-alag rules ke saath kaam karta hai, bas lambda badalna padta hai.

### `System.out::println`
Method reference: `e -> System.out.println(e)` ka chhota roop.

## ▶️ Output

```text
IT employees:
Rishabh (IT, 60000.0)
Neha (IT, 80000.0)
Salary > 50000:
Rishabh (IT, 60000.0)
Neha (IT, 80000.0)
Highest paid: Neha (IT, 80000.0)
```

## 🔑 Important Points

- Lambda se code me `if` aur anonymous classes ka bhaar kam hota hai.
- Ye hi idea Stream API me bhi use hota hai (`filter`, `map`).
- Method reference (`Class::method`) lambda ko aur short banata hai.

## 📝 Practice

1. Rule jodo: naam `A` se start hota ho.
2. Department ke hisab se salary ka total nikalo.
3. Do rules ko `&&` se combine karo.
4. Is code ko `Predicate<Employee>` se likho.

## 🚀 Challenge

`Predicate<Employee>` use karke project dobara likho aur `and()`/`negate()` ka use karo.
