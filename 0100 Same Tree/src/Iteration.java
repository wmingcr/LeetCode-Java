import java.util.ArrayDeque;
import java.util.Deque;

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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            Deque<TreeNode> s1 = new ArrayDeque<> ();
            Deque<TreeNode> s2 = new ArrayDeque<> ();
            while ((p != null && q != null) || (!s1.isEmpty () && !s2.isEmpty ())) {
                while (p != null && q != null) {
                    if (p.val != q.val) {
                        return false;
                    }
                    s1.push (p);
                    s2.push (q);
                    p = p.left;
                    q = q.left;
                }

                if ((p != null && q == null) || (p == null && q != null)) {
                    return false;
                }

                p = s1.pop ().right;
                q = s2.pop ().right;

            }

            if ((p != null && q == null) || (p == null && q != null)) {
                return false;
            }

            return true;
        }
    }

}
