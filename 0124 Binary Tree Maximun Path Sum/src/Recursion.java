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
        int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxPath (root);
            return max;
        }

        private int maxPath(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int L = Math.max (maxPath (node.left), 0);
            int R = Math.max (maxPath (node.right), 0);

            max = Math.max (max, L + R + node.val);

            return Math.max (L, R) + node.val;
        }
    }
}
