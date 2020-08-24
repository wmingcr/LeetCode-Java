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
        private int sum = 0;

        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                sum += root.val;
            }

            if (root.left != null) {
                root.left.val += root.val * 10;
                sumNumbers (root.left);
                //root.left.val -= root.val * 10;
            }

            if (root.right != null) {
                root.right.val += root.val * 10;
                sumNumbers (root.right);
                //root.right.val -= root.val * 10;
            }

            return sum;
        }
    }
}
