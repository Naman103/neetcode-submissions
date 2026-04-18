class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> posSpeedMap = new TreeMap<>(Collections.reverseOrder());
        int n = position.length;
        
        for(int i = 0; i < n; i++)
            posSpeedMap.put(position[i], speed[i]);

        Stack<Float> fleets = new Stack<>();
        for(Map.Entry<Integer, Integer> entry : posSpeedMap.entrySet()) {
            int pos = entry.getKey(), curSpeed = entry.getValue();
            float time = (float)(target - pos)/curSpeed;
            if(fleets.isEmpty() || time > fleets.peek())
                fleets.push(time);
        }

        return fleets.size();
    }
}
