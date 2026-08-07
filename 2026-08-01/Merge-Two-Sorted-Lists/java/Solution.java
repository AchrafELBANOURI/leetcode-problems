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
            
            int i = values.size() - 1 ;
            ListNode node = null;
            while(i >= 0){
                ListNode currNode = new ListNode(values.get(i--) , node);
                node = currNode;
            }

            return node;
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if(list1!=null){
            tail.next = list1;
        } else if ( list2!=null ){
            tail.next = list2;
        }

        return dummy.next;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();

        // Test Case 1
        System.out.println("Test Case 1:");
        List<Integer> list1 = List.of(1,2,4);
        List<Integer> list2 = List.of(1,3,4);
        ListNode head1 = ListNode.build(list1);
        ListNode head2 = ListNode.build(list2);
        ListNode newHead = s.mergeTwoLists(head1,head2);
        System.out.println("Result : " + ListNode.tearDown(newHead));
        
        // Test Case 2
        System.out.println("Test Case 2:");
        list1 = List.of();
        list2 = List.of();
        head1 = ListNode.build(list1);
        head2 = ListNode.build(list2);
        newHead = s.mergeTwoLists(head1,head2);
        System.out.println("Result : " + ListNode.tearDown(newHead));

        // Test Case 3
        System.out.println("Test Case 3:");
        list1 = List.of();
        list2 = List.of(0);
        head1 = ListNode.build(list1);
        head2 = ListNode.build(list2);
        newHead = s.mergeTwoLists(head1,head2);
        System.out.println("Result : " + ListNode.tearDown(newHead));
    }
}
