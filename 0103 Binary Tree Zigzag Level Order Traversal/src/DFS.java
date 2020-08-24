import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFS {

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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<List<Integer>> ();
            }

            List<List<Integer>> ans = new ArrayList<> ();
            DFS (root, 0, ans);
            return ans;
        }

        private void DFS(TreeNode root, int level, List<List<Integer>> ans) {
            if (level >= ans.size ()) {
                LinkedList<Integer> newLevel = new LinkedList<> ();
                newLevel.add (root.val);
                ans.add (newLevel);
            } else {
                if (level % 2 == 0) {
                    ans.get (level).add (root.val);
                } else {
                    ans.get (level).add (0, root.val);
                }
            }

            if (root.left != null) {
                DFS (root.left, level + 1, ans);
            }
            if (root.right != null) {
                DFS (root.right, level + 1, ans);
            }
        }
    }
}
