import java.util.HashSet;
import java.util.Set;

public class SetSs {

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
        public int numComponents(ListNode head, int[] G) {
            Set<Integer> set = new HashSet<> ();
            for (int g : G) {
                set.add (g);
            }

            ListNode curr = head;
            int ans = 0;
            while (curr != null) {
                if (set.contains (curr.val) && (curr.next == null || !set.contains (curr.next.val))) {
                    ans++;
                }
                curr = curr.next;
            }

            return ans;
        }
    }

}
