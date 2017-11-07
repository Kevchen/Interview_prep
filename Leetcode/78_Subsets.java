class Solution {
    //Using backtracking
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        for(int i=0;i<nums.length;i++){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[i]);
            helper(temp, nums, res, i+1);
        }
        return res;
    }
    public void helper (List<Integer> temp, int[] nums, List<List<Integer>> res, int curr){
        res.add(new ArrayList<Integer>(temp));
        for(int i = curr; i<nums.length; i++){
            temp.add(nums[i]);
            helper(temp,nums,res,i+1);
            temp.remove(temp.size()-1);
        }
    }
    //Iterative solution
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i: nums){
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> innerList : res){
                temp.add(new ArrayList<Integer>(innerList));
            }
            temp.add(new ArrayList<Integer>());
            for(List<Integer> innerList : temp){
                innerList.add(i);
            }
            res.addAll(temp);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }

    //Helper function
    public void printList(List<?> res){
        for(Object o : (List<?>) res){
            if(o instanceof Integer){
                System.out.print((Integer)o +",");
            }else{
                System.out.print("[");
                printList((List<?>)o);
                System.out.println("]");
            }
        }
    }
}