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
    public int goodNodes(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> treeQueue = new LinkedList<>();
        treeQueue.offer(new Pair<>(root, Integer.MIN_VALUE));
        int count = 0;

        while (!treeQueue.isEmpty()) {
            int size = treeQueue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> curPair = treeQueue.poll();
                TreeNode curNode = curPair.getKey();
                int curMaxNodeValue = curPair.getValue();
                if (curNode != null) {
                    if (curNode.val >= curMaxNodeValue) {
                        curMaxNodeValue = curNode.val;
                        count++;
                    }

                    treeQueue.offer(new Pair<>(curNode.left, curMaxNodeValue));
                    treeQueue.offer(new Pair<>(curNode.right, curMaxNodeValue));
                }
            }
        }

        return count;
    }
}
