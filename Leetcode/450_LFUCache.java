class LFUCache {
    int capacity;
    int count;
    public node head;
    HashMap<Integer,Doubly<Integer>> map;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.count=0;
        this.head = new node(null,null,1);
    }
    
    public int get(int key) {
        return map.contains(key) ? map.get(key) : -1;
    }
    
    public void put(int key, int value) {
        if(map.contains(key)){
            map.get(key).val = value;
        }else if(count==capacity){
            //remove
        }
        //insert
    }
}
class subnode{
    public int key,val;
    public subnode next, prev;
    public node parent;
    public subnode(int key, int value){
        this.key = key;
        this.val = val;
    }
    public node removeThis(){
        parent.resetHeadTail(this);
        if(this.prev!=null)
            this.prev.next = this.next;
        if(this.next!=null)
            this.next.prev = this.prev;
        return this;
    }
}
class node{
    public int val;
    public node prev,next;
    public subnode head,tail;
    public node(node prev, node next, int val){
        this.val=val;
        this.prev = prev;
        this.next = next;
    }
    public node insertNext(){
        //inserts node after this node   
        node temp = this.next;
        node newNode = new node(this,temp,1+this.val);
        this.next = newNode;
        if(temp!=null)
            temp.prev = newNode;
        return newNode;
    }
    public void insertSubNode(subnode s){
        //insert at tail
        if(head==null){
            head = s;
            tail = s;
        }else{
            tail.next = s;
            s.prev = tail;
            tail = s;
        }
    }
    public node removeLeastRecent(){
        //remove at head
        node temp = head;
        if(head==tail){
            //when head doesn't have a next
            head = null;
            tail = null;
            return temp;
        }
        head.next.prev = null;
        head = head.next;
        return temp;
    }
    public void resetHeadTail(node n){
        if(head==n){
            head = head.next;
        }else if(tail==n){
            tail = tail.prev;
        }
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */