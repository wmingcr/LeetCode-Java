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
        public TreeNode sortedArrayToBST(int[] nums) {
            // corner case
            if (nums == null || nums.length == 0) {
                return null;
            }
            return sort (nums, 0, nums.length - 1);
        }

        private TreeNode sort(int[] nums, int l, int r) {
            if (l > r) {
                return null;
            }

            int mid = l + (r - l) / 2;
            TreeNode root = new TreeNode (nums[mid]);
            root.left = sort (nums, l, mid - 1);
            root.right = sort (nums, mid + 1, r);
            return root;
        }
    }
}
