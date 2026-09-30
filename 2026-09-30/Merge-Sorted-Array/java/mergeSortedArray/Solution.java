package mergeSortedArray;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1 , p2 = n-1 , k = m + n - 1;

        while( p1 >= 0 && p2 >= 0 ){
            if( nums1[p1] < nums2[p2] ){
                nums1[k--] = nums2[p2--];
            }else{
                nums1[k--] = nums1[p1--];
            }
        }

        while( p2 >= 0 ){
            nums1[k--] = nums2[p2--];
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        int[] nums1_1 = new int[]{1,2,3,0,0,0};
        int m_1 = 3;
        int[] nums2_1 = new int[]{2,5,6};
        int n_1 = 3;
        sol.merge(nums1_1, m_1, nums2_1, n_1);
        int[] expected1 = new int[]{1,2,2,3,5,6};

        TestUtils.assertTest(
            expected1, 
            nums1_1,
            "Test Case 1"
        );

        // Test Case 2
        int[] nums1_2 = new int[]{1};
        int m_2 = 1;
        int[] nums2_2 = new int[]{};
        int n_2 = 0;
        sol.merge(nums1_2, m_2, nums2_2, n_2);
        int[] expected2 = new int[]{1};

        TestUtils.assertTest(
            expected2, 
            nums1_2,
            "Test Case 2"
        );

        // Test Case 3
        int[] nums1_3 = new int[]{0};
        int m_3 = 0;
        int[] nums2_3 = new int[]{1};
        int n_3 = 1;
        sol.merge(nums1_3, m_3, nums2_3, n_3);
        int[] expected3 = new int[]{1};

        TestUtils.assertTest(
            expected3, 
            nums1_3,
            "Test Case 3"
        );

    }
}
