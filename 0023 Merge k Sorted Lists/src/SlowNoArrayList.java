public class SlowNoArrayList {

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
            // corner case
            if (lists == null || lists.length == 0) {
                return null;
            }

            // get the validity length of lists
            int len = 0, length = lists.length;
            for (int i = 0; i < length; ) {
                if (lists[i] != null) {
                    len++;
                    i++;
                } else {
                    swap (lists, i, --length);
                }
            }

            ListNode dummy = new ListNode (0), prev = dummy;

            while (len > 0) {
                int k = 0, idx = 0;
                ListNode curr = lists[0];
                while (k < len) {
                    if (lists[k].val < curr.val) {
                        curr = lists[k];
                        idx = k;
                    }
                    k++;
                }
                prev.next = curr;
                prev = curr;
                if (curr.next != null) {
                    lists[idx] = lists[idx].next;
                } else {
                    len--;
                    swap (lists, idx, len);
                }
            }
            return dummy.next;
        }

        private void swap(ListNode[] lists, int i, int j) {
            ListNode te = lists[i];
            lists[i] = lists[j];
            lists[j] = te;
        }
    }
}
