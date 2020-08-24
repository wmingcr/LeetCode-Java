import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Ss1 {


    // Definition for a binary tree node.
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
        public List<TreeNode> generateTrees(int n) {
            return generateTrees (1, n);
        }

        private List<TreeNode> generateTrees(int l, int r) {
            List<TreeNode> ans = new ArrayList<> ();
            if (l > r) {
                return ans;
            }
            if (l == r) {
                ans.add (new TreeNode (l));
                return ans;
            }
            for (int root = l; root <= r; root++) {
                List<TreeNode> left = generateTrees (l, root - 1);
                List<TreeNode> right = generateTrees (root + 1, r);
                if (left.size () == 0) {
                    for (TreeNode i : right) {
                        TreeNode curr = new TreeNode (root);
                        curr.right = i;
                        ans.add (curr);
                    }
                }
                if (right.size () == 0) {
                    for (TreeNode i : left) {
                        TreeNode curr = new TreeNode (root);
                        curr.left = i;
                        ans.add (curr);
                    }
                }
                for (TreeNode i : left) {
                    for (TreeNode j : right) {
                        TreeNode curr = new TreeNode (root);
                        curr.left = i;
                        curr.right = j;
                        ans.add (curr);
                    }
                }
            }
            return ans;
        }
    }
}
