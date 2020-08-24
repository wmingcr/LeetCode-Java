import java.util.ArrayList;
import java.util.List;

public class Recursion {


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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new ArrayList<> ();
            find (root, 1, res);
            return res;
        }

        private void find(TreeNode root, int level, List<List<Integer>> res) {
            if (root != null) {
                if (level > res.size ()) {
                    res.add (0, new ArrayList<> ());
                }
                res.get (res.size () - level).add (root.val);
                find (root.left, level + 1, res);
                find (root.right, level + 1, res);
            }
        }
    }
}
