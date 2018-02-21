class Solution {
    //2 cases contains/not contains the characters
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        String result="";
        int[] count = new int[58];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t.length();++i){
            --count[t.charAt(i)-'A'];
        }
        while(start<=end){
            boolean flag = true;
            for(int j=0;j<58;++j)
                flag = count[j]<0?false:flag;
            if(flag){
                //contains
                if(result=="" || sb.length()<result.length())
                    result = sb.toString();
                --count[s.charAt(start)-'A'];
                ++start;
                sb.deleteCharAt(0);
            }else{
                //doesn't contains
                if(end==s.length())
                    break;
                sb.append(s.charAt(end));
                ++count[s.charAt(end)-'A'];
                ++end;
            }
        }
        return result;
    }
}