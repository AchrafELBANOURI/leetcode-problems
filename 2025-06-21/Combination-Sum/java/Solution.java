import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if( candidates.length == 0 ){
            return new ArrayList<>();
        }
        findPath(new ArrayList<>(), 0, target, candidates, res);
        return res;
    }

    private void findPath(List<Integer> path, int currInd, int currNodeTarget, int[] candidates, List<List<Integer>> res) {
        if (currNodeTarget == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = currInd; i < candidates.length ; i++) { 
            // Skip if current candidate is larger than remaining target
            if (candidates[i] > currNodeTarget) {
                continue;
            }
            
            // Skip if minimum value in remaining candidates is too large
            if (i < candidates.length - 1 && 
                candidates[i] < currNodeTarget - candidates[i] && 
                candidates[i] > currNodeTarget - candidates[i]) {
                continue;
            }
            
            path.add(candidates[i]);
            findPath(path, i, currNodeTarget - candidates[i], candidates, res);
            path.remove(path.size() - 1); // BackTracking
        }
    }
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int[] nums1 = {2};
        int target1 = 1;
        System.out.println(new Solution().combinationSum(nums1, target1)); // Expected: []
        
        // Test Case 2
        System.out.println("Test Case 2:");
        int[] nums2 = {};
        int target2 = 0;
        System.out.println(new Solution().combinationSum(nums2, target2)); // Expected: []
        
        // Test Case 3
        System.out.println("Test Case 3:");
        int[] nums3 = {2,3,6,7};
        int target3 = 7;
        System.out.println(new Solution().combinationSum(nums3, target3)); // Expected: [[2, 2, 3], [7]]
        
        // Test Case 4
        System.out.println("Test Case 4:");
        int[] nums4 = {2,3,5};
        int target4 = 8;
        System.out.println(new Solution().combinationSum(nums4, target4)); // Expected: [[2,2,2,2],[2,3,3],[3,5]]
        
        // Test Case 5
        System.out.println("Test Case 5:");
        int[] nums5 = {2};
        int target5 = 2;
        System.out.println(new Solution().combinationSum(nums5, target5)); // Expected: [[2]]
        
        // Test Case 6
        System.out.println("Test Case 6:");
        int[] nums6 = {1};
        int target6 = 2;
        System.out.println(new Solution().combinationSum(nums6, target6)); // Expected: [[1, 1]]
    }
}
