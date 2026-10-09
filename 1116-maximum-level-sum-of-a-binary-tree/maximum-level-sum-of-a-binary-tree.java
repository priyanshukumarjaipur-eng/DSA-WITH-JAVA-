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

class pair {
    TreeNode node;
    int lvl;
    pair(TreeNode node, int lvl) {
        this.node = node;
        this.lvl = lvl;
    }
}

class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 1));
        int sum = 0;
        int currlvl = 1;
        int max = 1;
        int prevsum = Integer.MIN_VALUE; 
        while (!q.isEmpty()) {
            pair curr = q.remove();
            if (curr.lvl > currlvl) {
                if (sum > prevsum) {
                    prevsum = sum;
                    max = currlvl;
                }
                sum = 0;
                currlvl = curr.lvl;
            }         
            sum += curr.node.val; 
            if (curr.node.left != null) q.add(new pair(curr.node.left, curr.lvl + 1));
            if (curr.node.right != null) q.add(new pair(curr.node.right, curr.lvl + 1));
        }  
        if (sum > prevsum) {
            max = currlvl;
        }
        
        return max;
    }
}
