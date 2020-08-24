public class RecursionSwap {

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
        TreeNode x = null, y = null, prev = null;

        public void recoverTree(TreeNode root) {
            findTwoSwapped (root);
            swap (x, y);
        }

        private void findTwoSwapped(TreeNode root) {
            if (root != null) {
                findTwoSwapped (root.left);
                if (prev != null && root.val < prev.val) {
                    y = root;
                    if (x == null) {
                        x = prev;
                    } else {
                        return;
                    }
                }
                prev = root;
                findTwoSwapped (root.right);
            }
        }

        private void swap(TreeNode x, TreeNode y) {
            int val = x.val;
            x.val = y.val;
            y.val = val;
        }
    }
}
