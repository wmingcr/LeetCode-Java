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
        public int maxDepth(TreeNode root) {
            return traversal (root, 0);
        }

        private int traversal(TreeNode node, int level) {

            if (node == null) {
                return level;
            }

            return Math.max (traversal (node.left, level + 1), traversal (node.right, level + 1));
        }
    }
}
