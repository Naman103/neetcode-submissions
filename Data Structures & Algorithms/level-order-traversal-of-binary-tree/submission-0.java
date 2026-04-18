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
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        levelOrderTraversal(root, 0);
        return result;
    }

    public void levelOrderTraversal(TreeNode root, int level) {
        if(root == null) return;
        if(result.isEmpty() || result.size() < level + 1) {
            List<Integer> res = new ArrayList<>();
            res.add(root.val);
            result.add(res);
        } else {
            result.get(level).add(root.val);
        }

        levelOrderTraversal(root.left, level + 1);
        levelOrderTraversal(root.right, level + 1);
    }
}
