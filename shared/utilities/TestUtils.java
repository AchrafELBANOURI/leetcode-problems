package utilities;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class TestUtils {

    // 1. Primitive Numbers (int, double, long, float, etc.)
    public static void assertTest(double expected, double actual, String testName) {
        // Double.compare handles NaN and -0.0 accurately vs pure ==
        printResult(Double.compare(expected, actual) == 0, expected, actual, testName);
    }

    // 2. Arrays (int[], double[], String[], etc.)
    public static void assertTest(int[] expected, int[] actual, String testName) {
        printResult(Arrays.equals(expected, actual), Arrays.toString(expected), Arrays.toString(actual), testName);
    }

    // 3. Collections (List, Set, Queue, etc.)
    public static void assertTest(Collection<?> expected, Collection<?> actual, String testName) {
        printResult(Objects.equals(expected, actual), expected, actual, testName);
    }

    // 4. Fallback for Objects & Strings
    public static void assertTest(Object expected, Object actual, String testName) {
        printResult(Objects.equals(expected, actual), expected, actual, testName);
    }

    // 5. 2D Arrays
    public static void assertTest(int[][] expected, int[][] actual, String testName) {
        printResult(Arrays.deepEquals(expected, actual), Arrays.deepToString(expected), Arrays.deepToString(actual), testName);
    }

    // Helper method to keep printing logic DRY
    private static void printResult(boolean passed, Object expected, Object actual, String testName) {
        if (passed) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.printf("FAIL: %s \nExpected: \"%s\" \nGot: \"%s\"%n", testName, expected, actual);
        }
    }
}