import java.util.ArrayDeque;
import java.util.Deque;

public class Session {

    public static void main(String[] args) {
        ListNode l4 = new Session.ListNode (4, null);
        ListNode l3 = new Session.ListNode (3, l4);
        ListNode l2 = new Session.ListNode (2, l3);
        ListNode l1 = new Session.ListNode (1, l2);

        print(l1);

        new Session.Solution ().reorderList (l1);

        print(l1);

    }

    private static void print(ListNode cur){
        while(cur != null){
            System.out.print (cur.val + "  ");
            cur = cur.next;
        }
        System.out.println ();
    }

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

    static class Solution {
        public void reorderList(ListNode head) {
            // corner case
            if (head == null || head.next == null) {
                return;
            }

            Deque<ListNode> queue = new ArrayDeque<> ();

            ListNode tem = head;
            while (tem != null) {
                queue.addLast (tem);
                tem = tem.next;
            }

            ListNode dummy = new ListNode (0, head), prev = dummy, curr = head;

            while (curr != null) {
                prev.next = curr;
                ListNode fromLast = queue.removeLast ();
                if (fromLast == curr) {
                    curr.next = null;
                    break;
                }
                prev = curr;
                curr = curr.next;
                prev.next = fromLast;
                if (fromLast == curr) {
                    fromLast.next = null;
                    break;
                }
            }

        }
    }
}
