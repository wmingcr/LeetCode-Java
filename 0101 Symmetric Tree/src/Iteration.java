import java.util.ArrayDeque;
import java.util.Deque;

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
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }

            Deque<TreeNode> stack1 = new ArrayDeque<> ();
            Deque<TreeNode> stack2 = new ArrayDeque<> ();
            TreeNode left = root.left, right = root.right;

            while (left != null && right != null || !stack1.isEmpty ()) {
                while (left != null && right != null) {
                    if (left.val != right.val) {
                        return false;
                    }
                    stack1.push (left);
                    stack2.push (right);
                    left = left.left;
                    right = right.right;
                }
                if (left == null && right != null || left != null && right == null) {
                    return false;
                }
                left = stack1.pop ().right;
                right = stack2.pop ().left;
            }

            if (left == null && right == null) {
                return true;
            }

            if (left != null || right != null) {
                return false;
            }

            return true;
        }
    }
}
