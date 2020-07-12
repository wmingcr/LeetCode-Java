import java.util.ArrayDeque;
import java.util.Deque;

public class WithStack {

    // not the best, just one way of solving this problem

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
        public ListNode reverseList(ListNode head) {
            // corner case
            if (head == null) {
                return null;
            }
            // store every node into Deque
            // cut the connections between them
            Deque<ListNode> qq = new ArrayDeque<> ();
            ListNode curr = head;
            while (curr != null) {
                qq.push (curr);
                ListNode te = curr;
                curr = curr.next;
                te.next = null;
            }

            ListNode ans = qq.pop ();
            curr = ans;

            while (qq.isEmpty () == false) {
                curr.next = qq.pop ();
                curr = curr.next;
            }

            return ans;
        }
    }
}
