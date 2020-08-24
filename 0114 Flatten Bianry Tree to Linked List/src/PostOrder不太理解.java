import java.util.Stack;

public class PostOrder不太理解 {
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
        public void flatten(TreeNode root) {
            Stack<TreeNode> toVisit = new Stack<> ();
            TreeNode cur = root;
            TreeNode pre = null;

            while (cur != null || toVisit.isEmpty () == false) {
                while (cur != null) {
                    toVisit.push (cur); // 添加根节点
                    cur = cur.right; // 递归添加右节点
                }

                cur = toVisit.peek (); // 已经访问到最右的节点
                // 在不存在左节点，或者右节点已经访问过的情况下，访问根节点
                if (cur.left == null || cur.left == pre) {
                    toVisit.pop ();
                    /*******以下是修改的地方*******/
                    cur.right = pre;
                    cur.left = null;
                    /***************************/
                    pre = cur;
                    cur = null;
                } else {
                    cur = cur.left;
                }
            }
        }
    }
}
