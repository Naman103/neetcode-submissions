class Solution {
    Map<Integer, List<Integer>> adjList;
    HashSet<Integer> visitedSet;
    HashSet<Integer> coursesTaken;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        prepareAdjacencyList(numCourses, prerequisites);
        visitedSet = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {
        if (visitedSet.contains(course))
            return false;
        
        if (adjList.get(course).isEmpty())
            return true;
        
        visitedSet.add(course);

        List<Integer> courses = adjList.get(course);
        for (int i : courses)
            if(!dfs(i))
                return false;
        
        visitedSet.remove(course);
        
        return true;
    }

    private void prepareAdjacencyList(int n, int[][] neighbors) {
        adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < neighbors.length; i++) {
            adjList.get(neighbors[i][0]).add(neighbors[i][1]);
        }
    }
}
