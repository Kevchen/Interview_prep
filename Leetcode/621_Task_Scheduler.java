class Solution {
    
    public int leastInterval(char[] tasks, int n) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        if(n==0)
            return tasks.length; 
        PriorityQueue<Integer> queue= new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet())
            queue.add(entry.getValue());
        while(!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int k = n+1;
            while(!queue.isEmpty() && k>0){
                int curr = queue.poll();
                if(curr>1)
                    temp.add(curr-1);
                result++;
                k--;
            }
            result +=(k>0 && !temp.isEmpty())?k:0;
            for(Integer i:temp){
                queue.add(i);
            }
        }
        return result;
    }
}