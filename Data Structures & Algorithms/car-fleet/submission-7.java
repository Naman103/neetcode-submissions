class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Float> posTimeMap = new TreeMap<>(Collections.reverseOrder());

        int n = position.length;
        for(int i = 0; i < n; i++) {
            float time = (float)(target - position[i])/speed[i];
            posTimeMap.put(position[i], time);
        }

        Stack<Float> carFleet = new Stack<>();
        
        for(int pos : posTimeMap.keySet()) {
            float time = posTimeMap.get(pos);
            if(carFleet.isEmpty() || carFleet.peek() < time)
                carFleet.push(time);
            
        }

        return carFleet.size();
    }
}
