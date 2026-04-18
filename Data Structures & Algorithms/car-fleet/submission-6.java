class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Float> posTimeMap = new TreeMap<>(Collections.reverseOrder());
        int n = position.length;

        for(int i = 0; i < n; i++)  {
            float time = (float) (target - position[i])/speed[i];
            posTimeMap.put(position[i], time);
        }

        Stack<Float> fleetTimeStack = new Stack<>();

        for(int key : posTimeMap.keySet()) {
            float timeValue = posTimeMap.get(key);

            if(fleetTimeStack.isEmpty() || fleetTimeStack.peek() < timeValue) {
                fleetTimeStack.push(timeValue);
            }
        }

        return fleetTimeStack.size();
    }
}
