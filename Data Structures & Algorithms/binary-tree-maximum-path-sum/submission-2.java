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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        helperMaxPathSum(root);
        return maxSum;
       
    }

    public int helperMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(helperMaxPathSum(root.left), 0);
        int rightSum = Math.max(helperMaxPathSum(root.right), 0);

        maxSum = Math.max(maxSum, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);

    }

}
