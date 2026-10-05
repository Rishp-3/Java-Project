# Two Dimensional Array in Java

## 📌 Topic
2D array ek table (rows aur columns) ki tarah data store karta hai. Ise array ka array bhi kehte hain.

## 🎯 What You Will Learn

- 2D array declare aur initialize karna
- Nested loops se traverse karna
- Rows aur columns ki length
- Matrix ka sum aur transpose

## 💻 Code

```java
public class TwoDimensional {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Rows: " + matrix.length);
        System.out.println("Cols: " + matrix[0].length);

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
                sum += matrix[i][j];
            }
            System.out.println();
        }
        System.out.println("Sum: " + sum);
    }
}
```

## 🧠 Explanation

### `int[][] matrix`
2D array. `matrix[i][j]` = i-th row ka j-th column.

### `matrix.length`
Rows ki sankhya.

### `matrix[0].length`
Pehli row me columns ki sankhya.

### `Nested loop`
Bahar wala loop rows ke liye, andar wala loop columns ke liye.

## ▶️ Output

```text
Rows: 3
Cols: 3
1 2 3 
4 5 6 
7 8 9 
Sum: 45
```

## 🔑 Important Points

- Index hamesha `[row][col]` order me hota hai.
- Java me har row ki length alag ho sakti hai (jagged array).
- `matrix[i].length` safe hai, jagged array me bhi kaam karta hai.

## 📝 Practice

1. Matrix ke diagonal elements ka sum nikalo.
2. Do matrices ko add karo.
3. Matrix ka transpose print karo.
4. Har row ka alag sum nikalo.

## 🚀 Challenge

3x3 matrix ka transpose print karo.

```text
1 4 7
2 5 8
3 6 9
```
