import java.util.*;

class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public static ListNode build( List<Integer> values ){
            // Edge Case
            if(values.isEmpty()){
                return null;
            }

            List<ListNode> nodes = new ArrayList<>(values.size());
            // First every element on the list should be a ListNode rather than Integer
            int i = 0;
            while(i<values.size()){
                nodes.add(new ListNode(values.get(i++),null));
            }

            // Second set next node of each node on nodes list to the next node on nodes list
            i = 0;
            while(i<nodes.size()-1){
                nodes.get(i).next = nodes.get(i+1);
                i++;
            }
            
            // return the first index ( head / parent node )
            return nodes.get(0);
        }

        public static List<Integer> tearDown( ListNode head ){
            List<Integer> values = new ArrayList<>();
            ListNode currNode = head;
            while(currNode != null){
                values.add(currNode.val);
                currNode = currNode.next;
            }

            return values;
        }
    }

    public ListNode reverseList_iterative(ListNode head) {
        ListNode prevNode = null , currNode = head , nextNode = null;
        while( currNode!=null ){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // Test Case 1
        System.out.println("Test Case 1:");
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        ListNode head = ListNode.build(values);
        ListNode newHead = s.reverseList_iterative(head);
        System.out.println("Result : " + ListNode.tearDown(newHead));
        
        // Test Case 2
        System.out.println("Test Case 2:");
        values = List.of(7,10);
        head = ListNode.build(values);
        newHead = s.reverseList_iterative(head);
        System.out.println("Result : " + ListNode.tearDown(newHead));

        // Test Case 3
        System.out.println("Test Case 3:");
        values = List.of();
        head = ListNode.build(values);
        newHead = s.reverseList_iterative(head);
        System.out.println("Result : " + ListNode.tearDown(newHead));
    }
}
