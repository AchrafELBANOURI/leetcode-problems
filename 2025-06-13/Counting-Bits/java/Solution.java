import java.util.*;

class Solution {
    public int[] countBits( int n ){
        int[] output = new int[n+1];
        output[0] = 0;
        for( int i = 1 ; i < n + 1 ; i++) 
            output[i] = output[i & (i-1)] + 1;
        return output;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Test Case 1:");
        int n = 0;
        System.out.println("Input: " + n);
        int[] result1 = solution.countBits(n);
        System.out.println("Output: " + Arrays.toString(result1));
        
        // Test Case 2
        System.out.println("Test Case 2:");
        n = 2;
        System.out.println("Input: " + n);
        int[] result2 = solution.countBits(n);
        System.out.println("Output: " + Arrays.toString(result2));

        // Test Case 3
        System.out.println("Test Case 3:");
        n = 5;
        System.out.println("Input: " + n);
        int[] result3 = solution.countBits(n);
        System.out.println("Output: " + Arrays.toString(result3));
    }
}
