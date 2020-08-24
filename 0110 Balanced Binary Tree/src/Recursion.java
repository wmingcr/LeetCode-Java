import javax.swing.tree.TreeNode;

public class Recursion {

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
        int isValid = 1;

        public boolean isBalanced(TreeNode root) {
            helper (root);
            return isValid == 1;
        }

        private int helper(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = helper (root.left);
            int right = helper (root.right);
            if (Math.abs (left - right) > 1) {
                isValid = 0;
            }
            return Math.max (left, right) + 1;
        }
    }
}
