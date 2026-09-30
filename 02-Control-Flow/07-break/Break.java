public class Break {
    public static void main(String[] args) {

        // 1. break inside a for loop - stops the loop completely
        System.out.println("Find first number divisible by 7:");
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println("Found: " + i);
                break; // exits the loop immediately
            }
        }

        // 2. break inside a while loop
        System.out.println("\nStop printing when we hit 5:");
        int i = 1;
        while (true) {
            if (i > 5) {
                break;
            }
            System.out.println(i);
            i++;
        }

        // 3. break with a label - exits the outer loop from inside a nested loop
        System.out.println("\nSearching in a 2D grid:");
        int[][] grid = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int target = 5;
        boolean found = false;

        outer:
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == target) {
                    System.out.println("Found " + target + " at row " + row + ", col " + col);
                    found = true;
                    break outer; // breaks BOTH loops, not just the inner one
                }
            }
        }

        if (!found) {
            System.out.println(target + " not found in grid");
        }

        // 4. break inside switch
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Some other day");
        }
    }
}
