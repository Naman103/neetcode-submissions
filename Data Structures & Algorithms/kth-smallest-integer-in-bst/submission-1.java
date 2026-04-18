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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        preOrderTraversal(root, sortedList);
        return sortedList.get(k -1);

    }

    public void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        
        preOrderTraversal(root.left, list);
        list.add(root.val);
        preOrderTraversal(root.right, list);

    }
    
}
