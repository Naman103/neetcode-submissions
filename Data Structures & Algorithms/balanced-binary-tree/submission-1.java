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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        boolean result = true;
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1)
            return false;
        
        result = isBalanced(root.left);
        if(result == false)
            return false;
        result = isBalanced(root.right);

        return result;
    }

    public int calculateHeight(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(calculateHeight(root.left), calculateHeight(root.right));
    }

}
