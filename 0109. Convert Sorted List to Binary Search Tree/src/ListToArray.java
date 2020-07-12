import java.util.ArrayList;
import java.util.List;

public class ListToArray {

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

        List<Integer> list = new ArrayList<> ();

        public TreeNode sortedListToBST(ListNode head) {
            getNumbers (head);
            return listToBST (0, list.size () - 1);
        }

        private TreeNode listToBST(int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode (list.get (mid));
            if (left == right) {
                return root;
            }
            root.left = listToBST (left, mid - 1);
            root.right = listToBST (mid + 1, right);
            return root;
        }

        private void getNumbers(ListNode head) {
            while (head != null) {
                list.add (head.val);
                head = head.next;
            }
        }
    }
}
