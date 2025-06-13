import java.util.*;

class Solution {
    public static int maxArea(int[] height) {
        int l = 0 , r = height.length - 1;
        int maxArea = 0;
        while( l < r ){
            if( height[r] <= height[l] ){
                maxArea = Math.max(maxArea , (r-l)*height[r]);
                r--;
            }
            else{
                maxArea = Math.max(maxArea , (r-l)*height[l]);
                l++;
            }
        }
        return maxArea ;
    } 
    public static void main(String[] args) {
        // Test Case 1: Example from problem statement
        System.out.println("Test Case 1:");
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected1 = 49;
        int result1 = maxArea(height1);
        System.out.printf("Result: %b, Expected: %d, Got: %d\n", 
                          result1 == expected1, expected1, result1);
        
        // Test Case 2: Example from problem statement
        System.out.println("\nTest Case 2:");
        int[] height2 = {1, 1};
        int expected2 = 1;
        int result2 = maxArea(height2);
        System.out.printf("Result: %b, Expected: %d, Got: %d\n", 
                          result2 == expected2, expected2, result2);
        
        // Test Case 3: Edge case with tall bars at ends
        System.out.println("\nTest Case 3:");
        int[] height3 = {10, 1, 1, 1, 1, 10};
        int expected3 = 50; // 10 * 5 = 50
        int result3 = maxArea(height3);
        System.out.printf("Result: %b, Expected: %d, Got: %d\n", 
                          result3 == expected3, expected3, result3);
        
        // Test Case 4: Edge case with decreasing heights
        System.out.println("\nTest Case 4:");
        int[] height4 = {5, 4, 3, 2, 1};
        int expected4 = 6; // min(5,3) * 2 = 6 or min(5,2) * 3 = 6 or min(5,1) * 4 = 4 or min(4,2) * 2 = 4 or min(4,1) * 3 = 3 or min(3,1) * 2 = 2 ==> 6
        int result4 = maxArea(height4);
        System.out.printf("Result: %b, Expected: %d, Got: %d\n", 
                          result4 == expected4, expected4, result4);
    }
}
