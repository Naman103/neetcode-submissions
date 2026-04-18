class MyHashSet {
    boolean[] visited;

    public MyHashSet() {
        visited = new boolean[1000001];   
    }
    
    public void add(int key) {
        visited[key] = true;
    }
    
    public void remove(int key) {
        visited[key] = false;
    }
    
    public boolean contains(int key) {
        return visited[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */