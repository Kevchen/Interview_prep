class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList<>();
        if(digits.length()==0)
            return res;
        else{
            res.add("");
            for(int i=0;i<digits.length();++i){
                while(res.peek().length()==i){
                    String temp = res.remove();
                    for(int j=0;j<letters[digits.charAt(i)-'0'].length();++j){
                        res.add(temp+letters[digits.charAt(i)-'0'].charAt(j));
                    }
                }
            }
        }
        return res;
    }
}