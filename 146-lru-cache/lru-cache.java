class LRUCache {
    class Node{
        int key,value;
        Node prev,next;
        public   Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer,Node> cache;
    private final Node head,tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
       Node newnode = cache.get(key);
       moveTofront(newnode);

       return newnode.value;
    }
    public void moveTofront(Node node){
        removefrontend(node);
        addtofront(node);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
           Node node = cache.get(key);
           node.value = value;
           moveTofront(node); 
        }else{
            if(capacity == cache.size()){
                removeleastuse();
            }
            Node node = new Node(key,value);
            cache.put(key,node);
            addtofront(node);
        }
        
    }

    public void removeleastuse(){
        Node node = tail.prev;
        cache.remove(node.key);
        removefrontend(node);
    }
    public void removefrontend(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public int addtofront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    return node.value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */