import java.util.*;

class Solution {
    public int climbStairs(int n) {
        int[] prev = new int[n+1];
        for(int i=0 ; i<n+1 ; i++){
            if( i < 4 ){
                prev[i] = i;
            }
            else{
                prev[i] = prev[i-1] + prev[i-2];}
            }
        return prev[n];
    } 
    
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        System.out.println("Test Case 1:");
        int n1 = 2;
        int expected1 = 2;
        int result1 = solution.climbStairs(n1);
        System.out.println("Input: " + n1);
        System.out.println("Expected: " + expected1 + ", Got: " + result1);
        System.out.println("Result: " + (result1 == expected1 ? "Passed" : "Failed"));

        // Test Case 2
        System.out.println("\nTest Case 2:");
        int n2 = 3;
        int expected2 = 3;
        int result2 = solution.climbStairs(n2);
        System.out.println("Input: " + n2);
        System.out.println("Expected: " + expected2 + ", Got: " + result2);
        System.out.println("Result: " + (result2 == expected2 ? "Passed" : "Failed"));

        // Test Case 3
        System.out.println("\nTest Case 3:");
        int n3 = 5;
        int expected3 = 8;
        int result3 = solution.climbStairs(n3);
        System.out.println("Input: " + n3);
        System.out.println("Expected: " + expected3 + ", Got: " + result3);
        System.out.println("Result: " + (result3 == expected3 ? "Passed" : "Failed"));

        // Test Case 4
        System.out.println("\nTest Case 4:");
        int n4 = 10;
        int expected4 = 89;
        int result4 = solution.climbStairs(n4);
        System.out.println("Input: " + n4);
        System.out.println("Expected: " + expected4 + ", Got: " + result4);
        System.out.println("Result: " + (result4 == expected4 ? "Passed" : "Failed"));
    }
}
