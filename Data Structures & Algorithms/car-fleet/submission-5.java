class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Float> posTimeMap = new TreeMap<>(Collections.reverseOrder());
        int n = position.length; 
        for(int i = 0; i < n; i++) {
            float time = (float) (target - position[i])/speed[i];
            posTimeMap.put(position[i], time);
        }

        Stack<Float> timeStack = new Stack<>();
        for(int pos : posTimeMap.keySet()) {
            float time = posTimeMap.get(pos);
            if(timeStack.isEmpty())
                timeStack.push(time);
            else {
                if(time > timeStack.peek())
                    timeStack.push(time);
            }
        }

        return timeStack.size();
    }
}
