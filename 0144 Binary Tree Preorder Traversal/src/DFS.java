import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class DFS {

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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<> ();
            DFS (root, ans);
            return ans;
        }

        private void DFS(TreeNode root, List<Integer> ans) {
            if (root != null) {
                ans.add (root.val);
                DFS (root.left, ans);
                DFS (root.right, ans);
            }
        }
    }
}
