package designHashmap;

import java.util.*;
import utilities.TestUtils;

class Solution {
    public static List<Integer> operations( String[] ops , int[][] values){
        if(!ops[0].equals("MyHashMap")){
            throw new IllegalArgumentException("HashMap Operation Must be the first One");
        }
        
        List<Integer> output = new ArrayList<>(ops.length);
        MyHashMap hm = new MyHashMap();
        output.add(null);

        for(int i = 1 ; i < ops.length ; i++){
            if(ops[i].equals("put")){
                hm.put(values[i][0],values[i][1]);
                output.add(null);
            } else if ( ops[i].equals("remove") ){
                hm.remove(values[i][0]);
                output.add(null);
            } else if ( ops[i].equals("get")){
                output.add(hm.get(values[i][0]));
            } else {
                throw new IllegalArgumentException("Unexpected Operation Name -- Allowed Operations : HashMap - put - remove - get , index : "+i);
            }
        }

        return output;
    }
    
    public static void main(String[] args) {
        // Test Case 1
        String[] inputOps = {"MyHashMap","put","put","get","get","put","get","remove","get"};
        int[][] inputValues = {
            {},{1,1},{2,2},{1},{3},{2,1},{2},{2},{2}
        };

        List<Integer> output = Solution.operations(inputOps,inputValues);
        List<Integer> expected = Arrays.asList(null,null,null,1,-1,null,1,null,-1);
        
        TestUtils.assertTest(
            expected, 
            output,
            "Test Case 1"
        );
    }
}
