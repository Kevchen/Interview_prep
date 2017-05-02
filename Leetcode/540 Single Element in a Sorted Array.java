/*
*  Single Element in a Sorted Array
*  Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
*/
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int right = nums.length()-1;
        int left = 0;
        while(left=right){
            int mid = (right-left)2+left;
            if(mid%2==0 && mid+1=right && nums[mid] != nums[mid+1]){
                if(mid-1left  nums[mid] != nums[mid-1])
                    return nums[mid];
                right = mid-2;
                continue;
            }else{
                left = mid+2;
            }
            if(mid%2==1 && mid-1=left && nums[mid]!=nums[mid-1]){
                if(mid+1left  nums[mid] != nums[mid+1])
                    return nums[mid];
                right = mid-2;
                continue;
            }else{
                left = mid+1;
            }
        }
        return 0;
    }
}