/*
* Using Hashmap memoization, time limit exceeded
*/
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         //use Hashset to find words faster
//         HashSet<String> Dict = new HashSet<>();
//         HashMap<String, Boolean> memo = new HashMap<>();
//         int maxlength=0;
//         for(String w: wordDict){
//             maxlength = w.length()>maxlength? w.length():maxlength;
//             Dict.add(w);
//         }
//         return helper(s,Dict,memo,maxlength);
//     }
//     public boolean helper(String s, HashSet<String> Dict, HashMap<String,Boolean> memo,int maxlength){
//         if(s.length()==0 || Dict.contains(s)){
//             return true;
//         }
//         for(int i=Math.min(maxlength,s.length());i>0;i--){
//             String temp = s.substring(0,i);
//             if(memo.containsKey(temp)){
//                 return memo.get(temp);
//             }
//             else if(Dict.contains(temp)){
//                 if(helper(s.substring(i),Dict,memo,maxlength)){
//                     memo.put(s.substring(i),true);
//                     return true;
//                 }else{
//                     memo.put(s.substring(i),false);
//                 }
//             }
//         }
//         return false;
//     }
// }
public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j =0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }