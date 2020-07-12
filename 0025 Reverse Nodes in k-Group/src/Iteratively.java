public class Iteratively {
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
        public ListNode reverseKGroup(ListNode head, int k) {
            // corner case
            if (head == null || head.next == null) {
                return head;
            }

            ListNode dummy = new ListNode (0);
            dummy.next = head;

            ListNode prev = dummy;
            ListNode curr = dummy.next;

            while (true) {
                int t = k;
                ListNode tem = curr;
                while (tem != null && t > 0) {
                    t--;
                    tem = tem.next;
                }
                if (t != 0) {
                    break;
                }

                t = k;

                ListNode l = prev;
                ListNode r = curr;
                while (t > 0) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    t--;
                }

                r.next = curr;
                l.next = prev;
                prev = r;
            }

            return dummy.next;
        }
    }
}
