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
import java.util.*;

class Solution {
    public static void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans); 
        int n = ans.size();
        int currFreq = 1;
        int maxFreq = 1;
        List<Integer> modes = new ArrayList<>();
        modes.add(ans.get(0));
        for (int i = 1; i < n; i++) {
            if (ans.get(i).equals(ans.get(i - 1))) {
                currFreq++;
            } else {
                currFreq = 1;
            }
            if (currFreq > maxFreq) {
                maxFreq = currFreq;
                modes.clear();
                modes.add(ans.get(i));
            } else if (currFreq == maxFreq) {
                modes.add(ans.get(i));
            }
        }
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }    
        return result;
    }
}
