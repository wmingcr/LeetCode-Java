import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BackTrack {
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
        List<String> ans = new ArrayList<> ();

        public List<String> binaryTreePaths(TreeNode root) {
            backtrack (root, "");
            return ans;
        }

        private void backtrack(TreeNode root, String curr) {
            if (root != null) {
                curr += Integer.toString (root.val);
                if (root.left == null && root.right == null) {
                    ans.add (curr);
                    return;
                }
                curr += "->";
                backtrack (root.right, curr);
                backtrack (root.left, curr);
            }
        }
    }
}
