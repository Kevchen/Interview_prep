/*
* Bursting balloons and calculate maximum amount of coins using dp memoization
* Not yet completed, this can be simplified
*/
class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int [][] f = new int[len][len];
        for(int i=0;i<len;i++){
            for(int j =0;j+i<len;j++){
                int highest = Integer.MIN_VALUE;
                for(int k = j;k<=j+i;k++){
                    int total=0;
                    int left = k-1;
                    int right = k+1;
                    if(k>j){
                        total += f[j][k-1];
                        left = j-1;
                    }if(k<j+i){
                        total +=f[k+1][j+i];
                        right = j+i+1;
                    }
                    left= left>=0? nums[left]:1;
                    right = right<len? nums[right]:1;
                    total+=nums[k]*left*right;
                    highest = highest<total? total:highest;
                }
                f[j][j+i] = highest;
            }
        }
        return len>0?f[0][len-1]:0;
    }
}