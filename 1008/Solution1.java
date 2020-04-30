/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
 //TC, O(nlgn), SC, O(1)
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        //validity
        if(preorder == null || preorder.length == 0){
            return new TreeNode();
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        // pass every node in the preorder, insert that node 
        for(int i = 1; i < preorder.length; i ++){
            buildBST(root, preorder[i]);
        }
        
        return root;
    }
    
    private void buildBST(TreeNode root, int tar){
        TreeNode curr = root;
        while(curr != null){
            if(tar < curr.val){
                if(curr.left == null){
                    curr.left = new TreeNode(tar);
                    return;
                }else{
                    curr = curr.left;
                }
            }else {
                if(curr.right == null){
                    curr.right = new TreeNode(tar);
                    return;
                }else{
                    curr = curr.right;
                }
            }
        }
    }
}
