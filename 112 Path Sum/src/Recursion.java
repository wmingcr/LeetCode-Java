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
        public boolean hasPathSum(TreeNode root, int sum) {
            // corner case
            if (root == null) {
                return false;
            }

            return helper (root, sum, 0);
        }

        private boolean helper(TreeNode root, int tar, int sum) {
            if (root == null) {
                return false;
            }

            if (root.left == null && root.right == null && root.val + sum == tar) {
                return true;
            }

            return helper (root.left, tar, sum + root.val) || helper (root.right, tar, sum + root.val);
        }
    }
}
