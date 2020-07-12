public class Recursion {
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

    /**
     * 如下方式 1 和 2 的对比。1 会更快一些，原因如下。
     * 2 的 || 判断每次都会判断两侧的内容是否成立。耽误了时间。
     * 导致 2 所花时间为 1ms，而 1 所花时间为 0ms
     */
    class Solution {
        public ListNode reverseList1(ListNode head) {
            // corner case
            if(head == null){
                return null;
            }

            ListNode curr = reverseList1(head.next);

            if(curr == null){
                return head;
            }

            ListNode nextNode = head.next;
            nextNode.next = head;
            head.next = null;

            return curr;
        }
        public ListNode reverseList2(ListNode head) {
            // corner case
            if(head == null || head.next == null){
                return head;
            }

            ListNode curr = reverseList2(head.next);

            ListNode next = head.next;
            next.next = head;
            head.next = null;

            return curr;
        }
    }
}
