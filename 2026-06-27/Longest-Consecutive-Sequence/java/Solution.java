import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        
        for(int n : nums){
            hs.add(n);
        }

        int longest = 0 ;

        for(int n : hs){
            if( !hs.contains(n-1) ){
                int length = 1;
                while ( hs.contains(n+length) ){
                    length+=1;
                }
                longest = Math.max( length , longest);
            }
        }

        return longest;
        
    }
    
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums = new int[]{100,4,200,1,3,2};
        Solution s = new Solution();
        int result = s.longestConsecutive(nums);
        System.out.println("Result is : " + result);
        
        // Test Case 2
        System.out.println("Test Case 2:");
        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        result = s.longestConsecutive(nums);
        System.out.println("Result is : " + result);
        
        // Test Case 3
        System.out.println("Test Case 3:");
        nums = new int[]{1,0,1,2};
        result = s.longestConsecutive(nums);
        System.out.println("Result is : " + result);
    }
}
