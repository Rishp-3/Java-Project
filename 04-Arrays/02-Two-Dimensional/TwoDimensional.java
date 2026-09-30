public class TwoDimensional {
    public static void main(String[] args) {

        // A 2D array is an array of arrays (rows x columns)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Accessing an element: matrix[row][col]
        System.out.println("Element at row 1, col 2: " + matrix[1][2]);

        // Printing the whole matrix
        System.out.println("Matrix:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        // Sum of all elements
        int sum = 0;
        for (int[] rowArr : matrix) {
            for (int value : rowArr) {
                sum += value;
            }
        }
        System.out.println("Sum of all elements: " + sum);

        // Transpose of the matrix
        int[][] transpose = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        System.out.println("Transpose:");
        for (int[] rowArr : transpose) {
            System.out.println(java.util.Arrays.toString(rowArr));
        }
    }
}
