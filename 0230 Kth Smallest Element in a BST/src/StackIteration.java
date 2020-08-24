import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class StackIteration {
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
        public int kthSmallest(TreeNode root, int k) {

            Deque<TreeNode> stack = new ArrayDeque<> ();
            while (root != null) {
                stack.push (root);
                root = root.left;
            }

            TreeNode ans = null;
            for (int i = 0; i < k; i++) {
                ans = stack.pop ();
                TreeNode right = ans.right;
                while (right != null) {
                    stack.push (right);
                    right = right.left;
                }
            }

            return ans.val;
        }
    }
}
