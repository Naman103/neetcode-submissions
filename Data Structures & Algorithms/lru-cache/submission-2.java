class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cacheMap;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new LinkedHashMap<>();
    }
    
    public int get(int key) {
        int value = -1;
        if (cacheMap.containsKey(key)) {
            value = cacheMap.get(key);
            cacheMap.remove(key);
            cacheMap.put(key, value);
        }

        return value;
    }
    
    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            cacheMap.remove(key);
            
            cacheMap.put(key, value);
            return;
        }

        if(cacheMap.size() >= capacity) {
            int firstKey = cacheMap.keySet().iterator().next();
            cacheMap.remove(firstKey);
        }

        
            cacheMap.put(key, value);
    }
}
