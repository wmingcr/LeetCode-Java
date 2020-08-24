import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<> ();

            postOrder (ans, root);

            return ans;
        }

        private void postOrder(List<Integer> ans, TreeNode root) {
            if (root != null) {
                postOrder (ans, root.left);
                postOrder (ans, root.right);
                ans.add (root.val);
            }
        }
    }
}
