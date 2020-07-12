public class TwoPointers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            // corner case
            if(head == null){
                return head;
            }
            // have a dummy
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            // two pointers
            ListNode slow = dummy;
            ListNode fast = dummy;

            for(int i = 0; i < n+1; i ++){
                fast = fast.next;
            }

            while(fast != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
