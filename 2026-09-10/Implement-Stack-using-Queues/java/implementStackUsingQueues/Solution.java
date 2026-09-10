package implementStackUsingQueues;

import java.util.*;
import utilities.TestUtils;

class Solution {
    enum Strategy {
        TWO_QUEUES_STACK,
        ONE_QUEUE_STACK,
    }

    public static List<Object> operations( String[] ops , int[] values , Strategy s){
        if(!ops[0].equals("MyStack")){
            throw new IllegalArgumentException("MyStack Operation Must be the first One");
        }
        
        List<Object> output = new ArrayList<>(ops.length);
        StackI stack = s.equals(Strategy.TWO_QUEUES_STACK) ? 
                            new TwoQueuesStack() 
                            : 
                            new OneQueueStack();
        output.add(null);

        for(int i = 1 ; i < ops.length ; i++){
            if(ops[i].equals("push")){
                stack.push(values[i]);
                output.add(null);
            } else if ( ops[i].equals("pop") ){
                output.add(stack.pop());
            } else if ( ops[i].equals("top")){
                output.add(stack.top());            
            } else if ( ops[i].equals("empty")){
                output.add(stack.empty());
            } else {
                throw new IllegalArgumentException("Unexpected Operation Name -- Allowed Operations : MyStack - push - pop - top - empty , index : "+i);
            }
        }

        return output;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String[] inputOps = {"MyStack","push","push","top","pop","empty"};
        int[] inputValues = {0,1,2,0,0,0};

        List<Object> output = Solution.operations(inputOps,inputValues,Strategy.TWO_QUEUES_STACK);
        List<Object> expected = Arrays.asList(null,null,null,2,2,false);
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case -- Two Queues Stack"
        );

        // Test Case 2
        output = Solution.operations(inputOps,inputValues,Strategy.ONE_QUEUE_STACK);
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case -- One Queue Stack"
        );
    }    
}
