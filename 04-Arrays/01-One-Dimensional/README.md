# One Dimensional Array in Java

## 📌 Topic
Array ek hi type ke multiple values ko ek saath store karne ka tarika hai. Har value ka ek index hota hai jo 0 se start hota hai.

## 🎯 What You Will Learn

- Array declare, create aur initialize karna
- Index se element access karna
- `length` property
- Array ko loop se traverse karna

## 💻 Code

```java
public class OneDimensional {
    public static void main(String[] args) {
        int[] marks = {70, 85, 90, 65, 80};

        System.out.println("First: " + marks[0]);
        System.out.println("Length: " + marks.length);

        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (double) sum / marks.length);

        for (int m : marks) {
            System.out.print(m + " ");
        }
        System.out.println();

        int[] nums = new int[3];
        nums[0] = 10;
        System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
    }
}
```

## 🧠 Explanation

### `int[] marks = {...}`
Array banata hai aur values ek saath daal deta hai.

### `marks.length`
Array ke elements ki sankhya (bina bracket ke, method nahi property hai).

### `for (int m : marks)`
Enhanced for loop: index ke bina har element ko ek-ek karke deta hai.

### `new int[3]`
3 size ka array banata hai. Default values `0` hoti hain.

## ▶️ Output

```text
First: 70
Length: 5
Sum: 390
Average: 78.0
70 85 90 65 80 
10 0 0
```

## 🔑 Important Points

- Index 0 se `length - 1` tak hota hai.
- Galat index par `ArrayIndexOutOfBoundsException` aata hai.
- Array ka size ek baar fix ho jaye to badal nahi sakta.
- Default values: `int` = 0, `double` = 0.0, `boolean` = false, `String` = null.

## 📝 Practice

1. 5 numbers ke array me sabse bada element nikalo.
2. Array ko reverse me print karo.
3. Array me even numbers count karo.
4. User se 5 numbers lekar array me store karo aur print karo.

## 🚀 Challenge

Array ke elements ka minimum aur maximum ek hi loop me nikalo. Array: `{4, 9, 1, 7, 3}`

```text
Min: 1
Max: 9
```
