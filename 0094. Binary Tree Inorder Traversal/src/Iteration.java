import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Iteration {

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
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<> ();
            // corner case
            if (root == null) {
                return ans;
            }
            Deque<TreeNode> stack = new ArrayDeque<> ();
            while (root != null || stack.isEmpty () == false) {
                if (root != null) {
                    stack.push (root);
                    root = root.left;
                } else {
                    root = stack.pop ();
                    ans.add (root.val);
                    root = root.right;
                }
            }
            return ans;
        }
    }

    class Solution2 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            Deque<TreeNode> stack = new ArrayDeque<>();
            while(root != null || stack.isEmpty() == false){
                while(root != null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
            return ans;
        }
    }
}
