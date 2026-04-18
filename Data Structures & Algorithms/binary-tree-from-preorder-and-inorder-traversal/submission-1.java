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
    HashMap<Integer, Integer> inOrderIndexMap;
    int pre_idx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrderIndexMap = new HashMap<>();
        pre_idx = 0;
        for (int i = 0; i < inorder.length; i++)
            inOrderIndexMap.put(inorder[i], i);
        
        return prepareTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode prepareTree(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        
        int rootVal= preorder[pre_idx++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inOrderIndexMap.get(rootVal);
        root.left = prepareTree(preorder, left,  mid - 1);
        root.right = prepareTree(preorder, mid + 1, right);

        return root;
    }
}
