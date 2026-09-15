import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
    private String build(String str) {
        Stack<Character> st = new Stack<>();
        
        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        return sb.toString();
    }
}
