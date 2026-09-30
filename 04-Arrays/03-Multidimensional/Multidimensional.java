public class Multidimensional {
    public static void main(String[] args) {

        // 3D array: think of it as a stack of 2D grids
        int[][][] cube = new int[2][2][2];

        int value = 1;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    cube[i][j][k] = value++;
                }
            }
        }

        System.out.println("3D array contents:");
        for (int i = 0; i < cube.length; i++) {
            System.out.println("Layer " + i + ":");
            for (int j = 0; j < cube[i].length; j++) {
                System.out.println("  " + java.util.Arrays.toString(cube[i][j]));
            }
        }

        // Jagged array - a 2D array where each row can have a different length
        int[][] jagged = new int[3][];
        jagged[0] = new int[] {1};
        jagged[1] = new int[] {1, 2};
        jagged[2] = new int[] {1, 2, 3};

        System.out.println("\nJagged array:");
        for (int[] row : jagged) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }
}
