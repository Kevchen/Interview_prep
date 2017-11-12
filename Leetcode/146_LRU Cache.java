class LRUCache {
    private int max, size;
    private HashMap<Integer,DoublyLinkedList> mp;
    private DoublyLinkedList head, tail;
    public LRUCache(int capacity) {
        size = 0;
        max = capacity;
        mp = new HashMap<Integer,DoublyLinkedList>();
        head = tail = null;
    }
    
    public int get(int key) {
        if(mp.containsKey(key)){
            DoublyLinkedList find = mp.get(key);
            if(find!=head){
                DoublyLinkedList prevNode = find.prev;
                DoublyLinkedList nextNode = find.next;
                if(find==tail){
                    prevNode.next = null;
                    tail=prevNode;
                    insertAtHead(key, find);
                }else{
                    prevNode.next = nextNode;
                    nextNode.prev = prevNode;
                    insertAtHead(key, find);
                }
            }
            return find.val;
        }
        //System.out.println("Not found");
        return -1;
    }
    
    public void put(int key, int value) {
        //System.out.println("Inserting " + key + " size= " + size);
        if(size==0){
            DoublyLinkedList toAdd = new DoublyLinkedList(key,value);
            toAdd.prev = toAdd.next = null;
            head = toAdd;
            tail = toAdd;
            mp.put(key,toAdd);
            size++;
        }
        else if(mp.containsKey(key)){
            DoublyLinkedList find = mp.get(key);
            if(find==head){
                find.val = value;
            }else{
                if(find==tail)
                    tail=find.prev;
                if(find.prev!=null)
                    find.prev.next = find.next;
                if(find.next!=null)
                    find.next.prev = find.prev;
                find.val = value;
                insertAtHead(key, find);
            }
        }else{
            if(size==max){
                //need to remove at tail
                //System.out.println("Removing " + tail.key);
                DoublyLinkedList toRemove = tail;
                if(tail.prev!=null){
                    tail=tail.prev;
                    tail.next = null;
                }
                mp.remove(toRemove.key);
                DoublyLinkedList newNode = new DoublyLinkedList(key,value);
                insertAtHead(key, newNode);
                
            }else{
                DoublyLinkedList newNode = new DoublyLinkedList(key,value);
                insertAtHead(key, newNode);
                size++;
            }
        }
        //System.out.println("Success");
    }
    public void insertAtHead (int key, DoublyLinkedList newHead){
        //System.out.println("Inserting head " + newHead.key + " previous head is " + head.key);
        head.prev = newHead;
        newHead.next = head;
        newHead.prev = null;
        head = newHead;
        mp.put(key,newHead);
    }
}
class DoublyLinkedList{
    public int val;
    public int key;
    public DoublyLinkedList prev, next;
    public DoublyLinkedList(int k,int v){
        key = k;
        val = v;
        prev = null;
        next = null;
    }
}
