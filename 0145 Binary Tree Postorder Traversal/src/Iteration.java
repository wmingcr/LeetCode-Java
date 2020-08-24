import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Iteration {


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
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> ans = new LinkedList<> ();
            if (root == null) {
                return ans;
            }

            Deque<TreeNode> stack = new ArrayDeque<> ();
            stack.push (root);

            while (stack.isEmpty () == false) {
                TreeNode node = stack.pollLast ();
                ans.addFirst (node.val);
                if (node.left != null) {
                    stack.add (node.left);
                }
                if (node.right != null) {
                    stack.add (node.right);
                }
            }

            return ans;
        }
    }
}
