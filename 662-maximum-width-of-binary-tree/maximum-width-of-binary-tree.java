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
import java.util.LinkedList;
import java.util.Queue;

class pair { 
    TreeNode node; 
    int level; 
    pair(TreeNode node, int level) { 
        this.node = node; 
        this.level = level; 
    } 
} 
class Solution { 
    public int widthOfBinaryTree(TreeNode root) { 
        if (root == null) return 0; 
        Queue<pair> q = new LinkedList<>(); 
        q.add(new pair(root, 0)); 
        int max = 0; 
        while (!q.isEmpty()) { 
            int size = q.size(); 
            int start = 0; 
            int end = 0;  
            for (int i = 0; i < size; i++) { 
                pair curr = q.remove(); 
                
                if (i == 0) start = curr.level; 
                if (i == size - 1) end = curr.level; 
                
                if (curr.node.left != null) {
                    q.add(new pair(curr.node.left, curr.level * 2)); 
                }
                if (curr.node.right != null) {
                    q.add(new pair(curr.node.right, curr.level * 2 + 1)); 
                }
            } 
            int clevel = end - start + 1; 
            if (clevel > max) { 
                max = clevel; 
            } 
        } 
        return max; 
    } 
}
