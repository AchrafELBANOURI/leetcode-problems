import java.util.*;

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result = result | (n & 1);
            n = n >>> 1;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        System.out.println("Test Case 1:");
        int n1 = 43261596; // 00000010100101000001111010011100
        System.out.println("Input: " + n1);
        System.out.println("Output: " + solution.reverseBits(n1)); // 964176192 (00111001011110000010100101000000)
        
        // Test Case 2
        System.out.println("Test Case 2:");
        int n2 = -3; // 11111111111111111111111111111101
        System.out.println("Input: " + n2);
        System.out.println("Output: " + solution.reverseBits(n2)); // -1073741825 (10111111111111111111111111111111)
        
        // Test Case 3
        System.out.println("Test Case 3:");
        int n3 = 0;
        System.out.println("Input: " + n3);
        System.out.println("Output: " + solution.reverseBits(n3)); // 0
    }
}
