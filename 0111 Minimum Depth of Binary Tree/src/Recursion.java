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
        public int minDepth(TreeNode root) {
            // corner case
            if (root == null) {
                return 0;
            }

            return getMin (root);
        }

        private int getMin(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            }

            if (root.left == null) {
                return getMin (root.right) + 1;
            }

            if (root.right == null) {
                return getMin (root.left) + 1;
            }

            return Math.min (getMin (root.left), getMin (root.right)) + 1;
        }
    }

}
