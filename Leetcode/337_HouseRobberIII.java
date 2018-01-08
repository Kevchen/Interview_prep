/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        int[] res = scan(root);
        return Math.max(res[0],res[1]);
    }
    public int[] scan(TreeNode node){
        //calculate the max of including the node and not including node separately
        int maxtaking=0;
        int maxnottaking=0;
        int[] left= {0,0};
        int[] right= {0,0};
        if(node.left!=null)
            left = scan(node.left);
        if(node.right!=null)
            right = scan(node.right);
        maxtaking = node.val+left[0]+right[0];
        maxnottaking = Math.max(left[1],left[0])+Math.max(right[1],right[0]);
        return new int[] {maxnottaking,maxtaking};
    }
}