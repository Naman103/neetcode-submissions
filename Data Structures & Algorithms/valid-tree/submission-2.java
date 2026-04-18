class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Set<Integer> visitedNodes = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        // Prepare adjacency list
        prepareAdjacencyList(n, edges);

        if(!traverseGraph(0, -1))
            return false;
        
        return visitedNodes.size() == n;

    }

    private boolean traverseGraph(int curNode, int parentNode) {
        if (visitedNodes.contains(curNode)) {

            return false;
        }

        visitedNodes.add(curNode);
        for (int neighbor : adjList.get(curNode)) {
            if (neighbor == parentNode)
                continue;
                
            if (!traverseGraph(neighbor, curNode))
                return false;
        }

        return true;
    }

    private void prepareAdjacencyList(int n, int[][] edges) {
        for (int i = 0; i < n; i++)
            adjList.put(i, new ArrayList<>());
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }
}
