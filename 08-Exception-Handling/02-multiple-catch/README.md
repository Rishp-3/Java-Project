# Multiple catch in Java

## 📌 Topic
Ek `try` block ke saath kai `catch` blocks lag sakte hain, taaki alag-alag exceptions ko alag tarike se handle kar sakein.

## 🎯 What You Will Learn

- Multiple catch blocks
- Multi-catch (`|`)
- Catch blocks ka order
- Parent `Exception` ko last me rakhna

## 💻 Code

```java
public class MultipleCatch {
    public static void main(String[] args) {
        String[] data = {"10", "abc", null};

        for (int i = 0; i < 4; i++) {
            try {
                String s = data[i];
                int n = Integer.parseInt(s);
                System.out.println("Number: " + n);
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index problem");
            } catch (Exception e) {
                System.out.println("Other error: " + e.getClass().getSimpleName());
            }
        }

        try {
            Object o = "text";
            Integer x = (Integer) o;
        } catch (ClassCastException | NullPointerException e) {
            System.out.println("Multi-catch: " + e.getClass().getSimpleName());
        }
    }
}
```

## 🧠 Explanation

### `Multiple catch`
Exception ke type ke hisab se pehla matching catch block chalta hai, baaki skip ho jate hain.

### `catch (A | B e)`
Ek hi block me kai exceptions pakadne ke liye `|` use hota hai.

### `catch (Exception e)`
Sabse general exception. Isse hamesha sabse last me likho.

## ▶️ Output

```text
Number: 10
Not a number
Not a number
Index problem
Multi-catch: ClassCastException
```

## 🔑 Important Points

- Child exception pehle, parent exception baad me likho. Ulta karoge to compile error aata hai.
- Ek time par sirf ek catch block chalta hai.
- Multi-catch me dono exceptions ek-doosre ke parent/child nahi hone chahiye.

## 📝 Practice

1. Teen alag exceptions ke liye teen alag catch likho.
2. Multi-catch se do exceptions ek saath pakdo.
3. Parent catch ko pehle likhke compile error dekho.
4. `getClass().getName()` print karo.

## 🚀 Challenge

Ek program banao jo array index, divide by zero aur string parsing teeno errors ek hi `try` me alag-alag catch se handle kare.
