// Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

// Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
// Paste: You can paste the characters which are copied last time.
// Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

public class Solution {
    int min = Integer.MAX_VALUE;
    public int minSteps(int n) {
        int remaining = n-1;
        int copied = 0;
        int current = 1;
        helper(remaining,current,0,0);
        return min;
    }
    public void helper(int remaining, int current, int lastCopied, int count)
    {
        if(remaining<0)
        {
            return;
        }else if(remaining==0){
            min = (count<min)? count : min;
        }
        helper(remaining-lastCopied, current + lastCopied, lastCopied, count++);
        helper(remaining, current, current, count++);
    }
}