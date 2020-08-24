import javax.swing.tree.TreeNode;

public class Recursion {

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
        public boolean isValidBST(TreeNode root) {
            return helper (root, null, null);
        }

        private boolean helper(TreeNode root, Integer lower, Integer upper) {
            if (root == null) return true;

            int val = root.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;

            return helper (root.left, lower, val) && helper (root.right, val, upper);
        }
    }
}
