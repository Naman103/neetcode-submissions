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
    HashMap<TreeNode, Integer> depthMap = new HashMap<>();
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        TreeNode temp = root;
        nodeDepth(temp);

        temp = root;
        int result = 0;
        for (TreeNode key : depthMap.keySet()) {
            result = Math.max(result,
                depthMap.getOrDefault(key.left, 0) + depthMap.getOrDefault(key.right,0));
        }

        return result;
    }

    public int nodeDepth(TreeNode root) {
        if (root == null)
            return 0;
    
        if (!depthMap.containsKey(root))
            depthMap.put(root, 1 + Math.max(nodeDepth(root.left), nodeDepth(root.right)));
        return depthMap.get(root);
    }
}
