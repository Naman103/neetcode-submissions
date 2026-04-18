class Solution {
    Map<Integer, List<Integer>> graphMap = new HashMap<>();
    Set<Integer> visitedSet = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        
        for(int i = 0; i < n; i++)
            graphMap.put(i, new ArrayList<>());
        
        for(int[] edge : edges) {
            graphMap.get(edge[0]).add(edge[1]);
            graphMap.get(edge[1]).add(edge[0]);
        }
        
        if(!dfs(0, -1)) return false;
        
        return visitedSet.size() == n;
    }

    private boolean dfs(int node, int parent) {
        if(visitedSet.contains(node))
            return false;
        
        visitedSet.add(node);
        for(int neighbor : graphMap.get(node)) {
            if(neighbor == parent) continue;
            if(!dfs(neighbor, node)) return false;
        }
        return true;
    }

}
