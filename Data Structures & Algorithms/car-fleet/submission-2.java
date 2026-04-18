class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> positionSpeedMap = new HashMap<>();
        int n = position.length;
        for(int i = 0; i < n; i++)
            positionSpeedMap.put(position[i], speed[i]);
        
        Arrays.sort(position);
        for(int i = 0; i < n/2; i++) {
            int temp = position[i];
            position[i] = position[n - i - 1];
            position[n - i - 1] = temp;
        }

        Stack<Float> timeStack = new Stack<>();
        float timeToReachTarget;
        timeStack.push((float)(target - position[0])/positionSpeedMap.get(position[0]));
        for(int i = 1; i < n; i++) {
            timeToReachTarget = (float)(target - position[i])/positionSpeedMap.get(position[i]);
            if(timeStack.peek() < timeToReachTarget) {
                timeStack.push(timeToReachTarget);
            } 
        }
        
        return timeStack.size();
        
    }
}
