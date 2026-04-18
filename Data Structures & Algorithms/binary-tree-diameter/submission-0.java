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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int leftRoot = maxLength(root.left);
        int rightRoot = maxLength(root.right);
        int diameter = leftRoot + rightRoot;
        int sub = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(diameter, sub);
    }

    public int maxLength(TreeNode root) {
        if(root == null) return 0;

        return 1 + Math.max(maxLength(root.left), maxLength(root.right));
    }
}
