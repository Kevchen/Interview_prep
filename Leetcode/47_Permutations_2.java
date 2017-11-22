/*Given a collection of numbers that might contain duplicates, return all possible unique permutations.
*/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(nums,used,new ArrayList<Integer>(),res);
        return res;
    }
    public void helper(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> res){
        if(curr.size()==nums.length){
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i =0; i<nums.length;i++){
            if(used[i] || (i!=0 && nums[i]==nums[i-1] && !used[i-1]))
                continue;
            used[i]=true;
            curr.add(nums[i]);
            helper(nums,used,curr,res);
            curr.remove(curr.size()-1);
            used[i]=false;
        }
    }
}