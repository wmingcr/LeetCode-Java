public class DummyNodeTheBestToMe {

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
            // get a dummy node before head
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            // get the length of list
            int len = 0;
            ListNode curr = head;
            while(curr != null){
                len++;
                curr = curr.next;
            }

            // find the node before Nth node
            int idx = 0;
            int tar = len - n;
            curr = dummy;
            while (idx < tar){
                idx++;
                curr = curr.next;
            }
            curr.next = curr.next.next;
            return dummy.next;
        }
    }
}
