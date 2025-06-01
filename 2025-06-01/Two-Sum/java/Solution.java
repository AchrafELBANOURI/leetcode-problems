import java.util.HashMap;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> H = new HashMap<>();
        H.put(target - nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (H.containsKey(nums[i]))
                return new int[] { H.get(nums[i]), i };
            else
                H.put(target - nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        // CASE 1
        int[] nums1 = new int[] { 2, 7, 11, 15 };
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Case 1 result: [" + result1[0] + "," + result1[1] + "]");

        // CASE 2
        int[] nums2 = new int[] { 3, 2, 4 };
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Case 2 result: [" + result2[0] + "," + result2[1] + "]");

        // CASE 3
        int[] nums3 = new int[] { 3, 3 };
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Case 3 result: [" + result3[0] + "," + result3[1] + "]");
    }
}