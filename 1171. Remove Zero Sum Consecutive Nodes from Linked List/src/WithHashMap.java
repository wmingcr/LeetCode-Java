import java.util.HashMap;

public class WithHashMap {

    // Definition for singly-linked list.
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
        public ListNode removeZeroSumSublists(ListNode head) {
            ListNode dummy = new ListNode (0, head), curr = dummy;
            int sum = 0;
            HashMap<Integer, ListNode> map = new HashMap<> ();
            while (curr != null) {
                sum += curr.val;
                map.put (sum, curr);
                curr = curr.next;
            }

            ListNode prev = dummy;
            sum = 0;
            for (curr = dummy; curr != null; curr = curr.next) {
                sum += curr.val;
                curr.next = map.get (sum).next;
            }
            return dummy.next;
        }
    }
}
