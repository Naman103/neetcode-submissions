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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
          return Collections.emptyList();
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
          int size = queue.size();
          List<Integer> levelList = new ArrayList<>();
          for (int i = 0; i < size; i++) {
            TreeNode currentNode = queue.poll();
            levelList.add(currentNode.val);
            if (currentNode.left != null)
              queue.offer(currentNode.left);
            
            if (currentNode.right != null)
              queue.offer(currentNode.right);
          }

          result.add(levelList);
        }

        return result;
    }
}
