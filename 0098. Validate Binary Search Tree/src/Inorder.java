public class Inorder {

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
        Integer val = null;

        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            boolean ans1 = isValidBST (root.left);
            if (!ans1 || val != null && root.val <= val) {
                return false;
            }
            val = root.val;
            return isValidBST (root.right);
        }
    }
}
