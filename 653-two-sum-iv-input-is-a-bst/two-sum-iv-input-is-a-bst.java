/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void store(TreeNode root,ArrayList<Integer> arr){
        if(root==null) return;
        store(root.left,arr);
        arr.add(root.val);
        store(root.right,arr);
    }
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        store(root,arr);
        int n=arr.size();
        int i=0;
        int j=n-1;
        while(i<j){
            int sum=arr.get(i)+arr.get(j);
            if(sum==k) return true;
            if(sum<k) i++;
            else j--;
        }
        return false;
    }
}