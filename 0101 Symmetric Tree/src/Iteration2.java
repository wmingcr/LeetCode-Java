import java.util.LinkedList;
import java.util.Queue;

public class Iteration2 {

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
        public boolean isSymmetric(TreeNode root) {
            return check (root, root);
        }

        private boolean check(TreeNode left, TreeNode right) {
            // Deque<TreeNode> ss = new ArrayDeque<>();
            Queue<TreeNode> ss = new LinkedList<TreeNode> ();
            ss.offer (left);
            ss.offer (right);
            while (!ss.isEmpty ()) {
                // left = ss.pop();
                // right = ss.pop();
                left = ss.poll ();
                right = ss.poll ();
                if (left == null && right == null) {
                    continue;
                }
                if ((left == null || right == null) || (left.val != right.val)) {
                    return false;
                }
                ss.offer (left.left);
                ss.offer (right.right);

                ss.offer (left.right);
                ss.offer (right.left);
            }
            return true;
        }
    }
}
