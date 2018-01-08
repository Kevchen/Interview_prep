class Solution {
    public int lengthLongestPath(String input) {
        String[] section = input.split("\n");
        String res="";
        int longest=0;
        Deque<Integer> prev = new ArrayDeque<>();
        prev.push(-1);
        for(String s:section){
            int len = s.length();
            s=s.replace("\t","");
            int level = len-s.length();
            while(level<=prev.peek()){
                //remove prev level
                res=res.substring(0,res.lastIndexOf('/'));
                prev.pop();
            }
            res+='/'+s;
            if(s.contains("."))
                longest = Math.max(longest, res.length());
            prev.push(level);
        }
        return longest==0 ? 0:longest-1;
    }
}