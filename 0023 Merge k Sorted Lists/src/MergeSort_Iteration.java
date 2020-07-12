public class MergeSort_Iteration {
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

            int k = lists.length;
            while (k > 1) {
                int idx = 0;
                for (int i = 0; i < k; i += 2) {
                    if (i == k - 1) {
                        lists[idx] = lists[i];
                    } else {
                        lists[idx] = merge (lists[i], lists[i + 1]);
                    }
                    idx++;
                }
                k = idx;
            }
            return lists[0];
        }

        private ListNode merge(ListNode a, ListNode b) {
            ListNode dummy = new ListNode (), prev = dummy;
            while (a != null && b != null) {
                if (a.val > b.val) {
                    prev.next = b;
                    b = b.next;
                } else {
                    prev.next = a;
                    a = a.next;
                }
                prev = prev.next;
            }
            prev.next = a != null ? a : b;
            return dummy.next;
        }
    }
}
