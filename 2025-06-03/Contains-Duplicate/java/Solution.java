import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinctValues = new HashSet<>();
        for (int item : nums) {
            if (distinctValues.contains(item))
                return true;
            else
                distinctValues.add(item);
        }
        return false;
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        Solution s = new Solution();
        int[] nums = new int[] { 1, 2, 3, 1 };
        System.out.println("Case 1 result = " + s.containsDuplicate(nums));

        // Test Case 2
        System.out.println("Test Case 2:");
        nums = new int[] { 1, 2, 3, 4 };
        System.out.println("Case 1 result = " + s.containsDuplicate(nums));

        // Test Case 3
        System.out.println("Test Case 3:");
        nums = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println("Case 1 result = " + s.containsDuplicate(nums));
    }
}
