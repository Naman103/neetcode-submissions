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
    List<List<Integer>> postOrder = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        levelOrderTraversal(root, 0);
        List<Integer> result = new ArrayList<>();
        for(List<Integer> level : postOrder) {
            result.add(level.get(level.size() - 1));
        }

        return result;
    }

    public void levelOrderTraversal(TreeNode root, int height) {
        if(root == null)
            return;
        
        if(postOrder.isEmpty() || postOrder.size() < height + 1) {
            List<Integer> res = new ArrayList<>();
            res.add(root.val);
            postOrder.add(res);
        } else {
            postOrder.get(height).add(root.val);
        }

        levelOrderTraversal(root.left, height + 1);
        levelOrderTraversal(root.right, height + 1);

    }
}
