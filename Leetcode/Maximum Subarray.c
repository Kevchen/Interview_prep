/*Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

int maxSubArray(int* nums, int numsSize) {
    int i=numsSize-2;
    int current=nums[numsSize-1];
    int max=nums[numsSize-1];
    while(i>-1){
       if(current<=0 && nums[i]> current){
           current = nums[i];
       }else if((current > 0 && nums[i]+current>0) || nums[i]>0){
           current += nums[i];
       }else{
          if(i>0){
              current = nums[i];
          } 
       }
       if(current>max){
           max=current;
       }
       i--;
    }
    return max;
}