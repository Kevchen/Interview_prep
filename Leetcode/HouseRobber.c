class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size()==0){
            return 0;
        }else if(nums.size()==1){
            return nums[0];
        }else{
            int now=0;
            int prev=0;
            int pprev=0;
            for(int i=0; i<nums.size();i++){
                pprev = prev;
                prev = now;
                now = max(prev, nums[i]+pprev);
            }
            return now;
        }
    }
};