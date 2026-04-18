class Solution {
    Map<Integer, List<Integer>> prereqCourseMap = new HashMap<>();
    Set<Integer> visitedSet = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) { 
        for(int i = 0; i < numCourses; i++)
            prereqCourseMap.put(i, new ArrayList<>());
        
        for(int[] prereq : prerequisites)
            prereqCourseMap.get(prereq[0]).add(prereq[1]);

        for(int course = 0; course < numCourses; course++)
            if(!dfs(course))
                return false;
            
        return true;
        
    }

    private boolean dfs(int course) {
        if (visitedSet.contains(course))
            return false;

        if (prereqCourseMap.get(course).isEmpty())
            return true;
        
        visitedSet.add(course);

        for(int pre : prereqCourseMap.get(course))
            if(!(dfs(pre)))
                return false;

        visitedSet.remove(course);
        return true;

    }
}
