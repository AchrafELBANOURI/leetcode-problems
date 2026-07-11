import java.util.*;

class Solution {
    public List<String> fizzBuzz(int n) {
        return new AbstractList<String>() {
            private final String FIZZ = "Fizz";
            private final String BUZZ = "Buzz";
            private final String FIZZBUZZ = "FizzBuzz";

            @Override
            public int size() {
                return n;
            }

            @Override
            public String get(int index) {
                int num = index + 1;

                if (num % 3 == 0 && num % 5 == 0) return FIZZBUZZ;
                if (num % 3 == 0) return FIZZ;
                if (num % 5 == 0) return BUZZ;
                return String.valueOf(num);
            }
        };
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // Test Case 1
        System.out.println("Test Case 1:");
        List<String> result = s.fizzBuzz(4);
        System.out.println(result);
        
        // Test Case 2
        System.out.println("Test Case 2:");
        result = s.fizzBuzz(0);
        System.out.println(result);
        
        // Test Case 3
        System.out.println("Test Case 3:");
        result = s.fizzBuzz(5);
        System.out.println(result);
    }
}
