import java.util.LinkedList;
import java.util.List;

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
        public List<String> binaryTreePaths(TreeNode root) {
            LinkedList<String> ans = new LinkedList<> ();
            if (root == null) {
                return ans;
            }

            LinkedList<TreeNode> node_stack = new LinkedList<> ();
            LinkedList<String> path_stack = new LinkedList<> ();
            node_stack.add (root);
            path_stack.add (Integer.toString (root.val));

            TreeNode node;
            String path;
            while (!node_stack.isEmpty ()) {
                node = node_stack.pollLast ();
                path = path_stack.pollLast ();
                if (node.left == null && node.right == null) {
                    ans.add (path);
                    continue;
                }
                if (node.left != null) {
                    node_stack.add (node.left);
                    path_stack.add (path + "->" + Integer.toString (node.left.val));
                }
                if (node.right != null) {
                    node_stack.add (node.right);
                    path_stack.add (path + "->" + Integer.toString (node.right.val));
                }
            }

            return ans;
        }
    }
}
