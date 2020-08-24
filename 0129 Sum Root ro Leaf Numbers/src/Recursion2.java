public class Recursion2 {
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
        public int sumNumbers(TreeNode root) {
            return sum (root, 0);
        }

        private int sum(TreeNode node, int currSum) {
            if (node == null) {
                return 0;
            }

            int tem = currSum * 10 + node.val;

            if (node.left == null && node.right == null) {
                return tem;
            }

            return sum (node.left, tem) + sum (node.right, tem);
        }
    }
}
