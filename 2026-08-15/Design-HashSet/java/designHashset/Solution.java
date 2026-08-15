package designHashset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utilities.TestUtils;

class Solution {
    enum Strategy {
        CHAINING,
        LINEAR_PROBING,
        QUADRATIC_PROBING,
        DOUBLE_HASHING,
    }

    public static HashSetI createHashSet(Strategy strategy){
        HashSetI hs = null;
        switch(strategy){
            case LINEAR_PROBING :
                hs = new LinearProbingHashSet();
                break;
            case QUADRATIC_PROBING :
                hs = new QuadraticProbingHashSet();
                break;
            case DOUBLE_HASHING :
                hs = new DoubleHashingHashSet();
                break;
            default :
                hs = new ChainingHashSet();
        }

        return hs;
    }

    public static List<Boolean> operations( String[] ops , int[] values , Strategy strategy){
        if(!ops[0].equals("HashSet")){
            throw new IllegalArgumentException("HashSet Operation Must be the first One");
        }
        
        List<Boolean> output = new ArrayList<>(ops.length);
        HashSetI hs = createHashSet(strategy);
        output.add(null);

        for(int i = 1 ; i < ops.length ; i++){
            if(ops[i].equals("add")){
                hs.add(values[i]);
                output.add(null);
            } else if ( ops[i].equals("remove") ){
                hs.remove(values[i]);
                output.add(null);
            } else if ( ops[i].equals("contains")){
                output.add(hs.contains(values[i]));
            } else {
                throw new IllegalArgumentException("Unexpected Operation Name -- Allowed Operations : HashSet - add - remove - contains , index : "+i);
            }
        }

        return output;
    }
    
    public static void main(String[] args) {

        // Test Case 1
        String[] inputOps = {"HashSet","add","add","add","remove","contains","add","add","add","remove","contains","add","add","add","remove","contains","add","add","add","remove","contains"};
        int[] inputValues = {0,1,10001,1,1,1,7,10007,7,7,7,123,10123,123,123,123,5000,15000,5000,5000,5000};
        List<Boolean> output = Solution.operations(inputOps,inputValues,Strategy.CHAINING);
        List<Boolean> expected = Arrays.asList(null,null,null,null,null,false,null,null,null,null,false,null,null,null,null,false,null,null,null,null,false);
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 1"
        );
        
        // Test Case 2
        output = Solution.operations(inputOps,inputValues,Strategy.LINEAR_PROBING);
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 2"
        );

        // Test Case 3
        output = Solution.operations(inputOps,inputValues,Strategy.QUADRATIC_PROBING);
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 3"
        );


        // Test Case 4
        output = Solution.operations(inputOps,inputValues,Strategy.DOUBLE_HASHING);
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 4"
        );
    }
}
