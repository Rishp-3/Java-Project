// Packages group related classes together and avoid naming conflicts.
// Normally you'd write: package com.example.basics;
// It's omitted here so the file can be compiled/run standalone, but in a
// real project this file would live inside the matching folder structure,
// e.g. com/example/basics/PackageBasics.java

public class PackageBasics {

    // A "sub-class" simulating another class that would normally live
    // in its own file within the same package.
    static class MathUtil {
        static int square(int n) {
            return n * n;
        }
    }

    public static void main(String[] args) {
        System.out.println("This class belongs to a package (conceptually).");
        System.out.println("Square of 6 = " + MathUtil.square(6));

        // Built-in Java packages you use all the time:
        // java.lang  -> String, Math, Integer (auto-imported)
        // java.util  -> ArrayList, HashMap, Scanner
        // java.io    -> File, InputStream
        System.out.println("Example from java.lang.Math: sqrt(16) = " + Math.sqrt(16));
    }
}
