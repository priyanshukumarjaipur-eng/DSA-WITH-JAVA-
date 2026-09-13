import java.util.Stack;
class Solution { 
    public int[] asteroidCollision(int[] ast) { 
        int n = ast.length; 
        Stack<Integer> st = new Stack<>(); 
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && ast[i] > 0 && st.peek() < 0 && -st.peek() < ast[i]) {
                st.pop(); 
            } 
            if (!st.isEmpty() && ast[i] > 0 && st.peek() < 0 && -st.peek() == ast[i]) {
                st.pop(); 
            } 
            else if (st.isEmpty() || !(ast[i] > 0 && st.peek() < 0 && -st.peek() > ast[i])) {
                st.push(ast[i]); 
            }
        } 
        
        int ans[] = new int[st.size()]; 
        for (int i = 0; i < ans.length; i++) { 
            ans[i] = st.pop(); 
        } 
        
        return ans; 
    } 
}
