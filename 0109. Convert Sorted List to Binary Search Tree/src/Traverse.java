public class Traverse {
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

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        ListNode head = null;

        public TreeNode sortedListToBST(ListNode head) {
            // get length
            int len = getLen (head);
            this.head = head;
            return sort (0, len - 1);
        }

        private TreeNode sort(int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            TreeNode leftNode = sort (left, mid - 1);
            TreeNode root = new TreeNode (head.val);
            root.left = leftNode;
            this.head = head.next;
            root.right = sort (mid + 1, right);
            return root;
        }

        private int getLen(ListNode head) {
            int len = 0;
            while (head != null) {
                len++;
                head = head.next;
            }
            return len;
        }
    }
}
