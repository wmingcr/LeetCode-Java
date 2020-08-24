public class Recursion {
    //* Definition for a binary tree node.
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
        TreeNode ans;
        int curr = 0;

        public int kthSmallest(TreeNode root, int k) {
            helper (root, k);
            return ans.val;
        }

        private void helper(TreeNode node, int k) {
            if (node == null) {
                return;
            }

            helper (node.left, k);


            if (++curr == k) {
                ans = node;
            }

            helper (node.right, k);
        }
    }
}
