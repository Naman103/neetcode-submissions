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
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return new ArrayList<>(map.values());
    }

    public void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        
        if (map.containsKey(level))
            map.get(level).add(root.val);
        else {
            List<Integer> nodeList = new ArrayList<>();
            nodeList.add(root.val);
            map.put(level, nodeList);
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
