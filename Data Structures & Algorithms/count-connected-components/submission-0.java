class Solution {
    Map<Integer, List<Integer>> adjList;
    Set<Integer> visitedNode;
    public int countComponents(int n, int[][] edges) {
        adjList = new HashMap<>();
        for (int i = 0; i < n; i++)
            adjList.put(i, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        int count = 0;
        visitedNode = new HashSet<>();
        for (int nodeKey : adjList.keySet()) {
            if (visitedNode.contains(nodeKey))
                continue;
            count++;
            dfs(nodeKey);
        }

        return count;
    }

    private void dfs(int nodeKey) {
        if (visitedNode.contains(nodeKey))
            return;
        
        visitedNode.add(nodeKey);
        for(int node : adjList.get(nodeKey)) {
            dfs(node);
        }
    }
}
