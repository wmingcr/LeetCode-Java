import java.util.ArrayList;
import java.util.List;

public class HalfReverse {

    public static class ListNode {
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

        @Override
        public String toString() {
            return String.valueOf (val);
        }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }

            List<ListNode> list = new ArrayList<> ();
            while (head != null) {
                list.add (head);
                head = head.next;
            }

            int i = 0, j = list.size () - 1;
            while (i < j) {
                list.get (i).next = list.get (j);
                i++;
                if (i == j) {
                    break;
                }
                list.get (j).next = list.get (i);
                j--;
            }
            list.get (i).next = null;

        }
    }
}
