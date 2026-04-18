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
    HashMap<Integer, List<Integer>> levelMap = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        dfs(root, 0);
        List<List<Integer>> levelMapList = new ArrayList<>(levelMap.values());
        
        for (List<Integer> levelList : levelMapList) {
            result.add(levelList.get(levelList.size() - 1));
        }

        return result;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        
        if (levelMap.containsKey(level))
            levelMap.get(level).add(root.val);
        else {
            List<Integer> levelValue = new ArrayList<>();
            levelValue.add(root.val);
            levelMap.put(level, levelValue);
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
