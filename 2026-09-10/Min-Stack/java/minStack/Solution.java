package minStack;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public static List<Object> operations( String[] ops , int[] values){
        if(!ops[0].equals("MinStack")){
            throw new IllegalArgumentException("MinStack Operation Must be the first One");
        }
        
        List<Object> output = new ArrayList<>(ops.length);
        MinStack stack = new MinStack();
        output.add(null);

        for(int i = 1 ; i < ops.length ; i++){
            if(ops[i].equals("push")){
                stack.push(values[i]);
                output.add(null);
            } else if ( ops[i].equals("pop") ){
                stack.pop();
                output.add(null);
            } else if ( ops[i].equals("top")){
                output.add(stack.top());            
            } else if ( ops[i].equals("getMin")){
                output.add(stack.getMin());
            } else {
                throw new IllegalArgumentException("Unexpected Operation Name -- Allowed Operations : MinStack - push - pop - top - geMin , index : "+i);
            }
        }

        return output;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String[] inputOps = {"MinStack","push","push","push","getMin","pop","top","getMin"};
        int[] inputValues = {0,-2,0,-3,0,0,0,0};

        List<Object> output = Solution.operations(inputOps,inputValues);
        List<Object> expected = Arrays.asList(null,null,null,null,-3,null,0,-2);
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case -- Min Stack"
        );
    }
}
