package maximumFrequencyStack;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public static List<Object> operations( String[] ops , int[] values){
        if(!ops[0].equals("FreqStack")){
            throw new IllegalArgumentException("FreqStack Operation Must be the first One");
        }
        
        List<Object> output = new ArrayList<>(ops.length);
        FreqStack stack = new FreqStack();
        output.add(null);

        for(int i = 1 ; i < ops.length ; i++){
            if(ops[i].equals("push")){
                stack.push(values[i]);
                output.add(null);
            } else if ( ops[i].equals("pop") ){
                output.add(stack.pop());
            } else {
                throw new IllegalArgumentException("Unexpected Operation Name -- Allowed Operations : FreqStack - push - pop , index : "+i);
            }
        }

        return output;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String[] inputOps = {"FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"};
        int[] inputValues = {0,5,7,5,7,4,5,0,0,0,0};

        List<Object> output = Solution.operations(inputOps,inputValues);
        List<Object> expected = Arrays.asList(null,null,null,null,null,null,null,5,7,5,4);
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case -- Freq Stack"
        );
    }
}
