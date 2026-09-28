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
    public static boolean check(TreeNode rl, TreeNode rr, int x, int y){ 
        if (rl == null || rr == null) return false; 
        if (rl != rr) {
            if (rl.left != null && rr.left != null) {
                if ((rl.left.val == x && rr.left.val == y) || (rl.left.val == y && rr.left.val == x)) return true;
            }
            if (rl.left != null && rr.right != null) {
                if ((rl.left.val == x && rr.right.val == y) || (rl.left.val == y && rr.right.val == x)) return true;
            }
            if (rl.right != null && rr.left != null) {
                if ((rl.right.val == x && rr.left.val == y) || (rl.right.val == y && rr.left.val == x)) return true;
            }
            if (rl.right != null && rr.right != null) {
                if ((rl.right.val == x && rr.right.val == y) || (rl.right.val == y && rr.right.val == x)) return true;
            }
        }        
        return check(rl.left, rr.left, x, y)   || 
               check(rl.left, rr.right, x, y)  || 
               check(rl.right, rr.left, x, y)  || 
               check(rl.right, rr.right, x, y);   
    } 

    public boolean isCousins(TreeNode root, int x, int y) { 
        if (root == null) return false;
        TreeNode rl = root; 
        TreeNode rr = root; 
        return check(rl, rr, x, y); 
    } 
}
