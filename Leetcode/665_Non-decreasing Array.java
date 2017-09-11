// Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
// We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

class Solution {
    public boolean checkPossibility(int[] nums) {
        int flag = 1;
        for(int i=1; i<nums.length && flag>=0;i++){
            if(nums[i]<nums[i-1]){
                flag--;
                if(i-2<0 || nums[i]>=nums[i-2])
                    nums[i-1] = nums[i];
                else
                    nums[i] = nums[i-1];
            }
        }
        return flag>=0;
    }
}