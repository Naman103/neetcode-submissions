class TimeMap {

    HashMap<String, TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (timeMap.containsKey(key)) {
            timeMap.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> timestampMap = new TreeMap<>();
            timestampMap.put(timestamp, value);
            timeMap.put(key, timestampMap);
        }
    }
    
    public String get(String key, int timestamp) {
        if (timeMap.containsKey(key)) {
            Integer floorKey = timeMap.get(key).floorKey(timestamp);
            if (floorKey == null)
                return "";
            return timeMap.get(key).get(floorKey);
        }

        return "";
    }
}
