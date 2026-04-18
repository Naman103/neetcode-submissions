class TimeMap {
    Map<String, TreeMap<Integer,String>> timeMap; 
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(timeMap.containsKey(key)) {
            timeMap.get(key).put(timestamp, value);
        } else {
            TreeMap<Integer, String> timeStampMap = new TreeMap<>();
            timeStampMap.put(timestamp, value);
            timeMap.put(key, timeStampMap);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return "";
        TreeMap<Integer, String> timestamps = timeMap.get(key);
        Map.Entry<Integer, String> entry = timestamps.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
