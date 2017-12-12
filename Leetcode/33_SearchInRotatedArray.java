class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            System.out.println("start=" + start + " " + "end=" + end);
            if(target>nums[end] && target<nums[start])
                return -1;
            int mid = start + (end-start)/2;
            System.out.println("mid=" + nums[mid]);
            if(nums[mid]==target){
                return mid;
            }if(nums[start] <= nums[mid]){
                //left part is sorted
                if(target<nums[mid] && target>=nums[start]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else{
                //right part is  sorted
                if(target>nums[mid] && target<=nums[end]){
                    start = mid+1;
                }else
                    end = mid-1;
            }
        }
        return -1;
    }
}