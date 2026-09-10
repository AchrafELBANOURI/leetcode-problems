package implementQueueUsingStacks;

import java.util.*;
import utilities.TestUtils;

class Solution {
    enum Strategy {
        TWO_STACKS_QUEUE,
    }

    public static List<Object> operations( String[] ops , int[] values , Strategy s){
        if(!ops[0].equals("MyQueue")){
            throw new IllegalArgumentException("MyQueue Operation Must be the first One");
        }
        
        List<Object> output = new ArrayList<>(ops.length);
        QueueI stack = new TwoStacksQueue();
        output.add(null);

        for(int i = 1 ; i < ops.length ; i++){
            if(ops[i].equals("push")){
                stack.push(values[i]);
                output.add(null);
            } else if ( ops[i].equals("pop") ){
                output.add(stack.pop());
            } else if ( ops[i].equals("peek")){
                output.add(stack.peek());            
            } else if ( ops[i].equals("empty")){
                output.add(stack.empty());
            } else {
                throw new IllegalArgumentException("Unexpected Operation Name -- Allowed Operations : MyQueue - push - pop - peek - empty , index : "+i);
            }
        }

        return output;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String[] inputOps = {"MyQueue","push","push","peek","pop","empty"};
        int[] inputValues = {0,1,2,0,0,0};

        List<Object> output = Solution.operations(inputOps,inputValues,Strategy.TWO_STACKS_QUEUE);
        List<Object> expected = Arrays.asList(null,null,null,1,1,false);
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case -- Two Stacks Queue"
        );
    }    
}
