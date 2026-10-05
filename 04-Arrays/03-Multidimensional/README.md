# Multidimensional Array in Java

## 📌 Topic
Java me 2 se zyada dimensions ke arrays bhi ban sakte hain, jaise 3D array. Ye data ko layers me store karte hain.

## 🎯 What You Will Learn

- 3D array ka structure
- Teen nested loops se traverse karna
- Jagged array (alag length ki rows)

## 💻 Code

```java
public class Multidimensional {
    public static void main(String[] args) {
        int[][][] cube = {
            { {1, 2}, {3, 4} },
            { {5, 6}, {7, 8} }
        };

        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    System.out.println("cube[" + i + "][" + j + "][" + k + "] = " + cube[i][j][k]);
                }
            }
        }

        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1};
        jagged[1] = new int[]{2, 3};
        jagged[2] = new int[]{4, 5, 6};

        for (int[] row : jagged) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
```

## 🧠 Explanation

### `int[][][] cube`
3D array: layers x rows x columns.

### `cube[i][j][k]`
i = layer, j = row, k = column.

### `new int[3][]`
Sirf rows ka size fix kiya, har row ka size baad me alag-alag de sakte hain (jagged array).

## ▶️ Output

```text
cube[0][0][0] = 1
cube[0][0][1] = 2
cube[0][1][0] = 3
cube[0][1][1] = 4
cube[1][0][0] = 5
cube[1][0][1] = 6
cube[1][1][0] = 7
cube[1][1][1] = 8
[1]
[2, 3]
[4, 5, 6]
```

## 🔑 Important Points

- Dimensions badhne par nested loops bhi badhte hain.
- Practical programs me 1D aur 2D arrays sabse zyada use hote hain.
- `Arrays.toString()` 1D array ko print karne me madad karta hai, `Arrays.deepToString()` multi-dimensional ke liye.

## 📝 Practice

1. 2x3x4 ka 3D array banao aur sabhi values 0 se bhar do.
2. 3D array ke sabhi elements ka sum nikalo.
3. Ek jagged array banao jisme Pascal triangle store ho.
4. `Arrays.deepToString()` se 2D array print karo.

## 🚀 Challenge

3 students ke 4 subjects ke marks 2D array me rakho aur har student ka total print karo.
