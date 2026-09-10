package onlineStockSpan;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public static List<Object> operations( String[] ops , int[] values){
        if(!ops[0].equals("StockSpanner")){
            throw new IllegalArgumentException("StockSpanner Operation Must be the first One");
        }
        
        List<Object> output = new ArrayList<>(ops.length);
        StockSpanner stack = new StockSpanner();
        output.add(null);

        for(int i = 1 ; i < ops.length ; i++){
            if(ops[i].equals("next")){
                output.add(stack.next(values[i]));
            } else {
                throw new IllegalArgumentException("Unexpected Operation Name -- Allowed Operations : StockSpanner - next , index : "+i);
            }
        }

        return output;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String[] inputOps = {"StockSpanner","next","next","next","next","next","next","next"};
        int[] inputValues = {0,100,80,60,70,60,75,85};

        List<Object> output = Solution.operations(inputOps,inputValues);
        List<Object> expected = Arrays.asList(null,1,1,1,2,1,4,6);
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case -- StockSpanner"
        );
    }
}
