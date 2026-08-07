class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];
        System.arraycopy(nums,0,ans,0,n);
        System.arraycopy(nums,0,ans,n,n);
        System.gc();
        return ans;
    }

    private static String arrayToString( int[] nums ){
        String mssg = "[ ";
        for(int i = 0 ; i < nums.length ; i++){
            if(nums.length-1 == i){
                mssg += String.valueOf(nums[i]);
            }else{
                mssg += String.valueOf(nums[i]) + ", ";
            }
        }
        return mssg + "]";
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // Test Case 1
        System.out.println("Test Case 1:");
        int[] input = {1,2,1};
        int[] output = s.getConcatenation(input);
        System.out.println("Input : " + Solution.arrayToString(input) + " Result : " + Solution.arrayToString(output));
        
        // Test Case 2
        System.out.println("Test Case 2:");
        input = new int[]{1,3,2,1};
        output = s.getConcatenation(input);
        System.out.println("Input : " + Solution.arrayToString(input) + " Result : " + Solution.arrayToString(output));
    }
}
