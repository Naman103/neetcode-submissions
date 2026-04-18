class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //Prepare adjacenyList
        Map<Integer, List<Integer>> adjList = new HashMap();
        for (int i = 0; i < numCourses; i++)
            adjList.put(i, new ArrayList<>());
        
        for (int[] preq: prerequisites) {
            adjList.get(preq[0]).add(preq[1]);
        }

        List<Integer> outputList = new ArrayList<>();
        Set<Integer> visitedCourses = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            if(fetchAllCourses(adjList, i, -1, visitedCourses, outputList))
                return new int[0];
        }

        int[] courseTakenList = new int[outputList.size()];
        for (int i = 0; i < outputList.size(); i++)
            courseTakenList[i] = outputList.get(i);
        
        return courseTakenList;

    }

    public boolean fetchAllCourses(Map<Integer, List<Integer>> adjList, int curNode, int parentNode, Set<Integer> visitedCourses, List<Integer> outputList) {
        if (visitedCourses.contains(curNode)) {
            if (curNode != parentNode)
                return true;
            return false;
        }

        visitedCourses.add(curNode);
        for (int neighbors : adjList.get(curNode)) {
            if(fetchAllCourses(adjList, neighbors, curNode, visitedCourses, outputList))
                return true;
        }

        visitedCourses.remove(curNode);
        if (!outputList.contains(curNode))
            outputList.add(curNode);
        return false;

    }
}
