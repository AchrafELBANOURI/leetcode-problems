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

    private static void assertTest(String expected, String actual, String testName) {
        if (expected.equals(actual)) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.printf("FAIL: %s | Expected: \"%s\", Got: \"%s\"%n", testName, expected, actual);
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test 1
        assertTest(
            "fl", 
            sol.longestCommonPrefix(new String[]{"flower", "flow", "flight"}),
            "Test Case 1"
        );

        // Test 2
        assertTest(
            "", 
            sol.longestCommonPrefix(new String[]{"dog", "racecar", "car"}), 
            "Test Case 2"
        );
    }
}
