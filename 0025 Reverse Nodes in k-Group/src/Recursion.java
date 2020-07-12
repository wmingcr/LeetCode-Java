public class Recursion {


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
        public ListNode reverseKGroup(ListNode head, int k) {
            // ending condition for recursion
            if (head == null || head.next == null) {
                return head;
            }
            // find the starting point for next k nodes
            int count = 0;
            ListNode curr = head;
            while (count < k && curr != null) {
                count++;
                curr = curr.next;
            }
            // reversing k nodes
            if (count == k) {
                // hold the start of next k nodes
                ListNode prev = reverseKGroup (curr, k);
                curr = head;
                int idx = 0;
                while (idx < k) {
                    ListNode next = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = next;
                    idx++;
                }
                return prev;
            } else {
                // number of left nodes are less than k
                return head;
            }

            // The following has reversed every node, even there are less than k nodes
            // curr = head;
            // int idx = 0;
            // while(idx < count){
            //     ListNode nextNode = curr.next;
            //     curr.next = prev;
            //     prev = curr;
            //     curr = nextNode;
            //     idx++;
            // }
            // return prev;
        }
    }
}
