/*
 *Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 */
class Solution {
    public int maximumSwap(int num) {
        char [] digits = Integer.toString(num).toCharArray();
        int[] bucket= new int[10];
        int max = 0;
        for(int i=0; i<digits.length;i++){
            bucket[digits[i]-'0']=i;
            max = digits[i]-'0' > max? digits[i]-'0':max;
        }
        for(int i=0; i<digits.length;i++){
            for(int j = max; j>digits[i]-'0';j--){
                if(bucket[j]>i){
                    System.out.println("comparing digits"+digits[i]+ " & "+digits[bucket[j]]);
                    char temp = digits[i];
                    digits[i]= digits[bucket[j]];
                    digits[bucket[j]] = temp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}