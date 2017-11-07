class MinStack {
    public ArrayDeque<Integer> deque;
    Integer min;
    /** initialize your data structure here. */
    public MinStack() {
        deque = new ArrayDeque<>();
        min=null;
    }
    
    public void push(int x) {
        if(min==null){
            min=x;
        }
        else if(x<=min){
            deque.push(min);
            min=x;
        }
        deque.push(x);
    }
    
    public void pop() {
        if(deque.size()>0){
            int temp = deque.pop();
            if(temp==min){
                if(!deque.isEmpty())
                    min = deque.pop();
                else
                    min = null;
            }
        }
    }
    
    public int top() {
        return deque.peek();
    }
    
    public int getMin() {
        return min;
    }
}
