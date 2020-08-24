public class StraitSolution_Worst {
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
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int val = 0;

            if (root.left != null) {
                val += rob (root.left.left) + rob (root.left.right);
            }

            if (root.right != null) {
                val += rob (root.right.left) + rob (root.right.right);
            }

            return Math.max (root.val + val, rob (root.left) + rob (root.right));
        }
    }
}
