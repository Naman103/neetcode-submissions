class TimeMap {

    Map<String, Map<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)) {
            map.get(key).put(timestamp, value);
        } else {
            Map<Integer, String> subMap = new HashMap<>();
            subMap.put(timestamp, value);
            map.put(key, subMap);
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            Map<Integer, String> subMap = map.get(key);
            if(subMap.containsKey(timestamp))
                return subMap.get(timestamp);
            else {
                List<Integer> timeStampList = new ArrayList<>();
                for(int ts : subMap.keySet())
                    timeStampList.add(ts);
                Collections.sort(timeStampList);
                int a = findSubKey(timeStampList, timestamp);
                if(a == -1) return "";
                return subMap.get(a);
            }
        } else {
            return "";
        }
    }

    private int findSubKey(List<Integer> timeStampList, int timestamp) {
        int left = 0, right = timeStampList.size() - 1;
        while(left <= right) {
            int mid = (int) Math.floor((left + right) / 2);
            if(timeStampList.get(mid) < timestamp)
                left = mid + 1;
            else
                right = mid - 1;
        }

        if(right < 0) return -1;
        return timeStampList.get(right) > timestamp ? -1 : timeStampList.get(right);
    }
}
