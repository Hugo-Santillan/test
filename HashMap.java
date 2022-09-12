class MyHashMap { hugo

    private class Entry {
        private int value;
        private int key;
        
        public Entry(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }
    
    private LinkedList<Entry>[] entries;
    
    public MyHashMap() {
        entries = new LinkedList[5];
    }
    
    private int hash(int key){
        return key % entries.length;
    }
    
    private List<Entry> getBucket(int key) {
        return entries[hash(key)];
    }
    
    private List<Entry> getOrCreateBucket(int key) {
        var bucket = entries[hash(key)];
        if(bucket != null)
            return bucket;
        
        entries[hash(key)] = new LinkedList<>();
        return entries[hash(key)];
    }
    
    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if(bucket != null)
            for(var entry : bucket)
                if(entry.key == key)
            return entry;
        return null;
    }
    
    public void put(int key, int value) {
        var entry = getEntry(key);
        if(entry != null) {
            entry.value = value;
            return;
        }
        
        getOrCreateBucket(key).add(new Entry(key, value));
        
    }
    
    public int get(int key) {
        var entry = getEntry(key);
        if(entry == null)
            return -1;
        return entry.value;
    }
    
    public void remove(int key) {
        var entry = getEntry(key);
        if(entry == null)
            return;
        getBucket(key).remove(entry);
    }
    
    
}
