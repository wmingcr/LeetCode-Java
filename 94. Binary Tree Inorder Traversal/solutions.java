/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        //inorder_Recursion(list, root);
        
        inorder_Stack(list, root);
        return list;
    }
    
    private void inorder_Recursion(List<Integer> list, TreeNode node){
        if(node != null){
            inorder_Recursion(list, node.left);
            list.add(node.val);
            inorder_Recursion(list, node.right);
        }   
    }
    
    private void inorder_Stack(List<Integer> list, TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || stack.size() >0){
            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
    }
}
