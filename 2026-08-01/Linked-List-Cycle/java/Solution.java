import java.util.*;

class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public static ListNode build( List<Integer> values , int pos ){
            ListNode head = null;
            ListNode tail = null;
            ListNode nodeAtPos = null;

            for(int i = 0; i < values.size(); i++){
                ListNode curr = new ListNode(values.get(i));
                if(head == null){
                    head = curr;
                } else {
                    tail.next = curr;
                }
                tail = curr;
                if(i == pos){
                    nodeAtPos = curr;
                }
            }

            // create cycle if pos is valid
            if(pos >= 0 && nodeAtPos != null){
                tail.next = nodeAtPos;
            }

            return head;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        
        ListNode slow = head , fast = head.next;

        while( slow != fast ){
            if( fast==null || fast.next==null ) return false;
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // Test Case 1
        System.out.println("Test Case 1:");
        int pos = 1;
        List<Integer> input = Arrays.asList(3,2,0,-4);
        ListNode head = ListNode.build(input,pos);
        boolean hasCycle = s.hasCycle(head);
        System.out.println("input : " + input + ", pos = " + pos + " : has Cycle ? "+ hasCycle);
        
        // Test Case 2
        System.out.println("Test Case 2:");
        input = Arrays.asList(1,2);
        pos = 0;
        head = ListNode.build(input,pos);
        hasCycle = s.hasCycle(head);
        System.out.println("input : " + input + ", pos = " + pos + " : has Cycle ? "+ hasCycle);
        
        // Test Case 3
        System.out.println("Test Case 3:");
        input = Arrays.asList(1);
        pos = -1;
        head = ListNode.build(input,pos);
        hasCycle = s.hasCycle(head);
        System.out.println("input : " + input + ", pos = " + pos + " : has Cycle ? "+ hasCycle);
    }
}
