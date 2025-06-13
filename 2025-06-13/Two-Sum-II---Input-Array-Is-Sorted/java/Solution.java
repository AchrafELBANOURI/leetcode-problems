class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0 , r = numbers.length - 1;
        while( l < r ){
            int two_sum = numbers[l] + numbers[r];
            if( two_sum == target ) return new int[]{l+1 , r+1};
            else if( two_sum < target ) l++;
            else r--;
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println("Test Case 1:");
        System.out.println("Input: numbers = [2,7,11,15], target = 9");
        System.out.println("Expected Output: [1,2]");
        System.out.print("Actual Output: [");
        System.out.print(result1[0] + "," + result1[1]);
        System.out.println("]");
        
        // Test Case 2
        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println("\nTest Case 2:");
        System.out.println("Input: numbers = [2,3,4], target = 6");
        System.out.println("Expected Output: [1,3]");
        System.out.print("Actual Output: [");
        System.out.print(result2[0] + "," + result2[1]);
        System.out.println("]");
        
        // Test Case 3
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println("\nTest Case 3:");
        System.out.println("Input: numbers = [-1,0], target = -1");
        System.out.println("Expected Output: [1,2]");
        System.out.print("Actual Output: [");
        System.out.print(result3[0] + "," + result3[1]);
        System.out.println("]");
    }
}