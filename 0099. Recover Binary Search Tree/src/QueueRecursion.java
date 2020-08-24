import javax.swing.tree.TreeNode;
import java.util.Collections;
import java.util.LinkedList;

public class QueueRecursion {
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
        public void recoverTree(TreeNode root) {
            LinkedList<Integer> storage = new LinkedList<> ();
            populateStorage (storage, root);
            Collections.sort (storage);
            check (storage, root);
        }

        private void check(LinkedList<Integer> storage, TreeNode root) {
            if (root != null) {
                check (storage, root.left);
                root.val = storage.poll ();
                check (storage, root.right);
            }
        }

        private void populateStorage(LinkedList<Integer> storage, TreeNode root) {
            if (root == null) return;
            populateStorage (storage, root.left);
            storage.push (root.val);
            populateStorage (storage, root.right);
        }
    }
}
