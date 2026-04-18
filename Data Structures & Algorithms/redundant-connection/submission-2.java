class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Set<Integer> visitedSet = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        // prepare Adjacency list
        int n = edges.length;  
        prepareAdjacencyList(edges);

        
        for (int i = n - 1; i >= 0; i--) {
            visitedSet.clear();
            int[] removedEdge = edges[i];
            if(dfs(1, -1, removedEdge) && visitedSet.size() == n)
                return removedEdge;
        }

        return new int[0];      
    }

    private boolean dfs(int curNode, int parentNode, int[] removedEdge) {
        if (visitedSet.contains(curNode)) {
            return false;
        }
        
        visitedSet.add(curNode);
        for (int neighbor : adjList.get(curNode)) {
            if (neighbor == parentNode ||
            (removedEdge[0] == curNode && removedEdge[1] == neighbor)
            || (removedEdge[1] == curNode && removedEdge[0] == neighbor)) {
                continue;
            }
            
            if(!dfs(neighbor, curNode, removedEdge)) {
                return false;
            } 
        }

        return true;
    }

    private void prepareAdjacencyList(int[][] edges) {
        int n = edges.length;
        for (int i = 1; i <= n; i++)
            adjList.put(i, new ArrayList<>());
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
    }

}
