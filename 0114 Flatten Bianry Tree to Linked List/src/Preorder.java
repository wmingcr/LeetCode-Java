import java.util.ArrayDeque;
import java.util.Deque;

public class Preorder {

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
        public void flatten(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<> ();
            if (root == null) {
                return;
            }
            stack.push (root);
            TreeNode prev = new TreeNode ();

            while (stack.isEmpty () == false) {
                TreeNode curr = stack.pop ();
                prev.right = curr;
                prev.left = null;
                prev = curr;
                if (curr.right != null) {
                    stack.push (curr.right);
                }
                if (curr.left != null) {
                    stack.push (curr.left);
                }
            }
        }
    }
}
