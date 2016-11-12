/* Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private int len;
    private LinkedList<Integer> queue;
    
    public LRUCache(int capacity) {
        map = new LinkedHashMap<Integer, Integer>();
        len = capacity;
        queue = new LinkedList<Integer>();
    }
    
    public int get(int key) {
        System.out.println("Get:" + key + " val=" + map.get(key));
        if(queue.indexOf(key)!=-1){
            queue.remove(queue.indexOf(key));
            queue.add(key);
            return map.get(key);
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        //System.out.println("Set:" + key + " val=" + value + " len=" + len);
        //System.out.println("indexOf:" + queue.indexOf(key));
        if(queue.indexOf(key)==-1 && len==0){
            System.out.println("Case 1");
            //remove here
            int keyToRemove = queue.pollFirst();
            map.remove(keyToRemove);
            //System.out.println("Removed:" + keyToRemove);
            queue.add(key);
            map.put(key, value);
        }else if(queue.indexOf(key)!=-1){
            //System.out.println("Case 2");
            queue.remove(queue.indexOf(key));
            queue.add(key);
            map.put(key,value);
        }else{
            //System.out.println("Case 3");
            map.put(key,value);
            queue.add(key);
            len--;
        }
        //System.out.println("Next to remove:" + queue.peek());
    }
}