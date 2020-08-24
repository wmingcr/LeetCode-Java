import javax.swing.tree.TreeNode;

public class BestRecursion {
    // * Definition for a binary tree node.
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
        private int res;

        public int countPairs(TreeNode root, int distance) {
            res = 0;
            helper (root, distance);
            return res;
        }

        private int[] helper(TreeNode root, int distance) {
            if (root == null) {
                return new int[distance + 1];
            }

            int[] left = helper (root.left, distance);
            int[] right = helper (root.right, distance);

            int[] A = new int[distance + 1];

            if (root.left == null && root.right == null) {
                A[1] = 1;
                return A;
            }

            for (int i = 1; i < distance; i++) {
                for (int j = 1; j < distance; j++) {
                    if (i + j <= distance) {
                        res += (left[i] * right[j]);
                    } else {
                        break;
                    }
                }
            }

            for (int i = 0; i < distance; i++) {
                A[i + 1] += left[i];
                A[i + 1] += right[i];
            }

            return A;
        }
    }
}
