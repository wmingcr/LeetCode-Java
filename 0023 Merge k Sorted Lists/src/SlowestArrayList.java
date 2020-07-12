import java.util.ArrayList;

public class SlowestArrayList {

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
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummy = new ListNode ();
            // corner case
            if (lists == null || lists.length == 0) {
                return null;
            }

            int m = lists.length;
            var list = new ArrayList<ListNode> (m);

            for (int i = 0; i < m; i++) {
                if (lists[i] != null) {
                    list.add (lists[i]);
                }
            }

            ListNode prev = dummy;
            while (list.isEmpty () == false) {
                int len = list.size ();

                ListNode curr = list.get (0);
                int tar = curr.val;
                int k = 0;
                while (k < len) {
                    if (list.get (k).val < tar) {
                        curr = list.get (k);
                        tar = curr.val;
                    }
                    k++;
                }
                prev.next = curr;
                prev = curr;
                ListNode next = curr.next;
                list.remove (curr);
                if (next != null) {
                    list.add (next);
                }
            }
            return dummy.next;
        }
    }
}
