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
class Solution {
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res=new ArrayList<>();
    //     inorder(root,res);
    //     return res;
    // }
    // private void inorder(TreeNode node,List<Integer> res){
    //     if(node==null){
    //         return;
    //     }
    //     inorder(node.left,res);
    //     res.add(node.val);
    //     inorder(node.right,res);
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;

        while (current != null) {
            if (current.left == null) {
                // If there's no left child, visit the current node and move to the right
                result.add(current.val);
                current = current.right;
            } else {
                // Find the inorder predecessor of the current node
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // If the predecessor's right child is null, create a thread to the current node
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // If the predecessor's right child points to the current node,
                    // it means we've already visited the left subtree, so remove the thread,
                    // visit the current node, and move to the right
                    predecessor.right = null; // Remove the thread
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }
}