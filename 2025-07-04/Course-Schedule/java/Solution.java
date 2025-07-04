import java.util.*;

class Solution {
    private Set<Integer> visited = new HashSet<>();
    private HashMap<Integer,List<Integer>> hm = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited.clear();
        hm.clear();

        for(int i=0 ; i<numCourses ; i++){
            hm.put(i,new ArrayList<Integer>());
        }

        for( int[] pair : prerequisites ){
            hm.get(pair[0]).add(pair[1]);
        }

        for(int i=0 ; i<numCourses ; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;

    } 
    private boolean dfs( int currentCourse ){
        if(visited.contains(currentCourse)){
            return false;
        }
        if(hm.get(currentCourse).isEmpty()){
            return true ;
        }

        visited.add(currentCourse);
        for( int prereq : hm.get(currentCourse)) {
            if(!dfs(prereq)){
                return false;
            }
        }

        visited.remove(currentCourse);
        hm.get(currentCourse).clear();
        return true;
    }
    public static void main(String[] args) {
        // Test Case 1
        System.out.println("Test Case 1:");
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Input: " + Arrays.deepToString(prerequisites1));
        System.out.println("Output: " + new Solution().canFinish(numCourses1, prerequisites1)); // Expected: true

        // Test Case 2
        System.out.println("Test Case 2:");
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Input: " + Arrays.deepToString(prerequisites2));
        System.out.println("Output: " + new Solution().canFinish(numCourses2, prerequisites2)); // Expected: false

        // Test Case 3
        System.out.println("Test Case 3:");
        int numCourses3 = 3;
        int[][] prerequisites3 = {{1, 0}, {2, 1}, {0, 2}};
        System.out.println("Input: " + Arrays.deepToString(prerequisites3));
        System.out.println("Output: " + new Solution().canFinish(numCourses3, prerequisites3)); // Expected: false
    }
}
