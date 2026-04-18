class Solution {
    HashMap<Integer, List<Integer>> courseAndPrereqMap = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    List<Integer> outputList = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++)
            courseAndPrereqMap.put(i, new ArrayList<>());
        
        for(int[] preReq : prerequisites)
            courseAndPrereqMap.get(preReq[0]).add(preReq[1]);
        
        for(int i = 0; i < numCourses; i++)
            if(!dfs(i))
                return new int[0];
        
        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            result[i] = outputList.get(i);
        
        return result;
    }

    private boolean dfs(int course) {
        if(visited.contains(course))
            return false;
        
        if(outputList.contains(course))
            return true;
        
        visited.add(course);
        for(int crs : courseAndPrereqMap.get(course))
            if(!dfs(crs))
                return false;
        
        visited.remove(course);
        outputList.add(course);
        return true;

    }

}
