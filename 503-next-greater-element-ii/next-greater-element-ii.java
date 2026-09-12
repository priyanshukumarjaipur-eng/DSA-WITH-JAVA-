import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ng[] = new int[n]; 
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currentIdx = i % n; 
            while (!st.isEmpty() && st.peek() <= nums[currentIdx]) {
                st.pop();
            }
            ng[currentIdx] = (st.isEmpty()) ? -1 : st.peek();
            st.push(nums[currentIdx]);
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ng[i];
        }
        
        return nums;
    }
}
