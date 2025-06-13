import java.util.*;

class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        System.out.println("Test Case 1:");
        int n1 = 11; // Binary: 00000000000000000000000000001011
        int expected1 = 3;
        int result1 = solution.hammingWeight(n1);
        System.out.println("Input: " + Integer.toBinaryString(n1));
        System.out.println("Expected: " + expected1 + ", Got: " + result1);
        
        // Test Case 2
        System.out.println("\nTest Case 2:");
        int n2 = 128; // Binary: 00000000000000000000000010000000
        int expected2 = 1;
        int result2 = solution.hammingWeight(n2);
        System.out.println("Input: " + Integer.toBinaryString(n2));
        System.out.println("Expected: " + expected2 + ", Got: " + result2);
    }
}
