import java.util.ArrayList;
import java.util.List;

public class MisteryA {
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<> ();
            helper (ans, root, 0);
            return ans;
        }

        private void helper(List<Integer> ans, TreeNode node, int depth) {
            if (node == null) {
                return;
            }

            if (ans.size () == depth) {
                ans.add (node.val);
            }

            helper (ans, node.right, depth + 1);
            helper (ans, node.left, depth + 1);
        }
    }
}
