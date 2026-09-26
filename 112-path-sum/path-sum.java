class Solution {
    public static boolean check(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return check(root.left, targetSum - root.val) || check(root.right, targetSum - root.val);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return check(root, targetSum);
    }
}

