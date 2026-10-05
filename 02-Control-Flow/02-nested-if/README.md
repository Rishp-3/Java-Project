# Nested if in Java

## 📌 Topic
Ek `if` ke andar dusra `if` likhna Nested if kehlata hai. Isse multi-level conditions check hoti hain.

## 🎯 What You Will Learn

- Nested if ka structure
- Multiple conditions ko step-by-step check karna
- Nested if aur `&&` me difference

## 💻 Code

```java
import java.util.Scanner;

public class NestedIf {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age >= 18) {

            System.out.print("Are you a citizen? (true/false): ");
            boolean citizen = sc.nextBoolean();

            if (citizen) {

                System.out.print("Do you have valid ID? (true/false): ");
                boolean hasId = sc.nextBoolean();

                if (hasId) {
                    System.out.println("You are eligible.");
                } else {
                    System.out.println("Valid ID required.");
                }

            } else {
                System.out.println("Citizenship requirement not met.");
            }

        } else {
            System.out.println("You are underage.");
        }

        sc.close();
    }
}
```

## 🧠 Explanation

### `if (age >= 18)`
Outer condition. Ye true ho tabhi andar ke checks hote hain.

### `if (citizen)`
Second level check. Sirf adult user se citizenship poochi jati hai.

### `if (hasId)`
Third level check. Teeno conditions pass hone par hi `You are eligible.` print hota hai.

## ⌨️ Sample Input

```text
20
true
true
```

## ▶️ Output

```text
Enter your age: Are you a citizen? (true/false): Do you have valid ID? (true/false): You are eligible.
```

## 🔑 Important Points

- Zyada nesting se code padhna mushkil ho jata hai, 3 level se zyada avoid karo.
- Simple cases me `&&` se nested if ko ek line me likh sakte ho.
- Har `else` apne sabse nazdeeki `if` se judta hai.

## 📝 Practice

1. Login system: pehle username check karo, phir password.
2. Teen numbers me largest nested if se nikalo.
3. ATM: card valid hai, PIN sahi hai, balance kaafi hai - teeno check karo.
4. Nested if ko `&&` me convert karo.

## 🚀 Challenge

Admission eligibility program banao: marks >= 60 ho, entrance test pass ho, aur age 17 se zyada ho tabhi `Admitted` print ho, warna reason print ho.
