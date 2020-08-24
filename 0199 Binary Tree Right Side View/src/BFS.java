import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<> ();
            if (root == null) {
                return ans;
            }

            Queue<TreeNode> queue = new ArrayDeque<> ();
            queue.add (root);

            while (!queue.isEmpty ()) {
                int n = queue.size ();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll ();
                    if (i == n - 1) {
                        ans.add (node.val);
                    }
                    if (node.left != null) {
                        queue.add (node.left);
                    }
                    if (node.right != null) {
                        queue.add (node.right);
                    }
                }
            }

            return ans;
        }
    }
}
