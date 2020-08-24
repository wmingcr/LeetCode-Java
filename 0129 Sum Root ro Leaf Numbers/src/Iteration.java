import java.util.ArrayDeque;
import java.util.Queue;

public class Iteration {
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
            int sum = 0;
            if (root == null) {
                return sum;
            }

            Queue<TreeNode> queue = new ArrayDeque<> ();
            queue.add (root);

            while (!queue.isEmpty ()) {
                int n = queue.size ();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll ();
                    if (node.left == null && node.right == null) {
                        sum += node.val;
                    }
                    if (node.left != null) {
                        node.left.val += node.val * 10;
                        queue.add (node.left);
                    }
                    if (node.right != null) {
                        node.right.val += node.val * 10;
                        queue.add (node.right);
                    }
                }
            }

            return sum;
        }
    }
}
