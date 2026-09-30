public class Continue {
    public static void main(String[] args) {

        // 1. continue skips the rest of the current iteration only
        System.out.println("Odd numbers from 1 to 10:");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // skip even numbers, go to next iteration
            }
            System.out.println(i);
        }

        // 2. continue inside a while loop
        System.out.println("\nSkip multiples of 3:");
        int i = 0;
        while (i < 10) {
            i++;
            if (i % 3 == 0) {
                continue;
            }
            System.out.println(i);
        }

        // 3. continue with a label - skips to the next iteration of the OUTER loop
        System.out.println("\nPrint pairs, skipping when they are equal:");
        outer:
        for (int a = 1; a <= 3; a++) {
            for (int b = 1; b <= 3; b++) {
                if (a == b) {
                    continue outer; // skip the rest of the inner loop AND move outer loop forward
                }
                System.out.println("a=" + a + ", b=" + b);
            }
        }
    }
}
