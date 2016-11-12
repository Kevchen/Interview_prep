public class Solution {
    public void moveZeroes(int[] nums) {
        int temp=0;
        int count=0;
        for(int i=0; i< nums.length;i++){
            if(nums[i]==0){
            }else{
                int hold = nums[i];
                nums[i] = 0;
                nums[temp] = hold;
                temp++;
            }
        }
    }