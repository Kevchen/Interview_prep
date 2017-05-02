/*
	Given an input string, reverse the string word by word.
*/
public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int i = parts.length-1;
        while(i>=0)
        {
            sb.append(parts[i]+" ");
            i--;
        }
        return sb.toString().trim();
    }
}