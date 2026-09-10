package simplifyPath;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        String[] stack = new String[parts.length];
        int top = 0 ;

        for(String p : parts){
            if (p.isEmpty() || p.equals(".")) {
                continue;
            }
            
            if(p.equals("..")){
                if( top > 0 ){
                    top--;
                }
            }
            else{
                stack[top] = p;
                    top++;
            }
        }

        if(top==0) return "/";

        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < top ; i++ ){
            result.append("/").append(stack[i]);
        }

        return result.toString();
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String path_1 = "/home/";
        String output1 = sol.simplifyPath(path_1);
        String expected1 = "/home";

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        String path_2 = "/home//foo/";
        String output2 = sol.simplifyPath(path_2);
        String expected2 = "/home/foo";

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

        // Test Case 3
        String path_3 = "/home/user/Documents/../Pictures";
        String output3 = sol.simplifyPath(path_3);
        String expected3 = "/home/user/Pictures";

        TestUtils.assertTest(
            expected3, 
            output3,
            "Test Case 3"
        );

        // Test Case 4
        String path_4 = "/../";
        String output4 = sol.simplifyPath(path_4);
        String expected4 = "/";

        TestUtils.assertTest(
            expected4, 
            output4,
            "Test Case 4"
        );

        // Test Case 5
        String path_5 = "/.../a/../b/c/../d/./";
        String output5 = sol.simplifyPath(path_5);
        String expected5 = "/.../b/d";

        TestUtils.assertTest(
            expected5, 
            output5,
            "Test Case 5"
        );

    }
}
