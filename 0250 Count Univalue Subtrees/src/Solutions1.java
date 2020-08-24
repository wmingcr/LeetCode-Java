import javax.swing.tree.TreeNode;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solutions1 {
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
        public int countUnivalSubtrees(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;
            Stack<TreeNode> stack = new Stack<TreeNode> ();
            Stack<TreeNode> stackR = new Stack<TreeNode> ();
            Set<TreeNode> set = new HashSet<TreeNode> ();
            stack.push (root);
            while (!stack.isEmpty ()) {
                TreeNode node = stack.pop ();
                if (node.left == null && node.right == null) set.add (node);
                else if (stackR.isEmpty () == false && stackR.peek () == node) {
                    stackR.pop ();
                    if (node.left == null && set.contains (node.right) && node.right.val == node.val) set.add (node);
                    else if (node.right == null && set.contains (node.left) && node.left.val == node.val)
                        set.add (node);
                    else if (node.left != null && node.right != null && node.left.val == node.right.val
                            && node.left.val == node.val) set.add (node);
                } else {
                    stack.push (node);
                    stackR.push (node);
                    if (node.right != null) stack.push (node.right);
                    if (node.left != null) stack.push (node.left);
                }
            }
            return set.size ();
        }
    }
}
