class Solution {
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        for(int i=0;i<size;++i){
            if(nums[i]>size || nums[i]<1)
                continue;
            else if(nums[i]-1!=i && nums[nums[i]-1]!=nums[i]){
                swap(nums,i,nums[i]-1);
                i--;
            }  
        }
        for(int j=0;j<size;++j)
            if(nums[j]!=j+1)
                return j+1;
        return size+1;
    }
    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}