package numberOfMatchingSubsequences;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // Count Word Frequencies
        Map<String,Integer> wordCounts = new HashMap<>();
        for(String word : words){
            wordCounts.put(word,wordCounts.getOrDefault(word,0)+1);
        }

        // compute the total matching
        int result = 0 ;
        for(Map.Entry<String,Integer> entry : wordCounts.entrySet()){
            String word = entry.getKey();
            int count = entry.getValue();

            if(isValidSequence(s,word)){
                result += count;
            }
        }

        return result;
    }

    private boolean isValidSequence(String s , String word){
        int idx = -1;
        for( int i = 0 ; i < word.length() ; i++){
            char c = word.charAt(i);
            idx = s.indexOf(c , idx+1);
            if(idx == -1) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1
        String s_1 = "abcde";
        String[] words_1 = new String[]{"a","bb","acd","ace"};
        int output1 = sol.numMatchingSubseq(s_1, words_1);
        int expected1 = 3;

        TestUtils.assertTest(
            expected1, 
            output1,
            "Test Case 1"
        );

        // Test Case 2
        String s_2 = "dsahjpjauf";
        String[] words_2 = new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        int output2 = sol.numMatchingSubseq(s_2, words_2);
        int expected2 = 2;

        TestUtils.assertTest(
            expected2, 
            output2,
            "Test Case 2"
        );

    }
}
