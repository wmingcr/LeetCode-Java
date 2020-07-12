import java.util.ArrayDeque;
import java.util.Deque;

public class DequeArrayDeque {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // corner case
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            Deque<Integer> s1 = new ArrayDeque<> ();
            Deque<Integer> s2 = new ArrayDeque<> ();
            ListNode c1 = l1, c2 = l2;

            while (c1 != null) {
                s1.push (c1.val);
                c1 = c1.next;
            }

            while (c2 != null) {
                s2.push (c2.val);
                c2 = c2.next;
            }

            ListNode prev = null;
            int carrier = 0;
            while (!s1.isEmpty () || !s2.isEmpty () || carrier != 0) {
                int t1 = 0, t2 = 0;
                if (!s1.isEmpty ()) {
                    t1 = s1.poll ();
                }
                if (!s2.isEmpty ()) {
                    t2 = s2.poll ();
                }
                int sum = t1 + t2 + carrier;
                ListNode curr = new ListNode (sum % 10);
                curr.next = prev;
                prev = curr;
                carrier = sum / 10;
            }
            return prev;
        }
    }
}
