import utilities.TestUtils;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String pref = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(pref)) {
                pref = pref.substring(0, pref.length() - 1);

                if (pref.isEmpty()) {
                    return "";
                }
            }
        }

        return pref;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test 1
        TestUtils.assertTest(
            "fl", 
            sol.longestCommonPrefix(new String[]{"flower", "flow", "flight"}),
            "Test Case 1"
        );

        // Test 2
        TestUtils.assertTest(
            "", 
            sol.longestCommonPrefix(new String[]{"dog", "racecar", "car"}), 
            "Test Case 2"
        );
    }
}
