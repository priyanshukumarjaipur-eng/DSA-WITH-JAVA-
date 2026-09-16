class Solution { 
    public String removeOuterParentheses(String s) { 
        int n = s.length(); 
        Stack<Character> st = new Stack<>(); 
        StringBuilder ans = new StringBuilder(); 
        for (int i = 0; i < n; i++) { 
            char c = s.charAt(i); 
            if (c == '(') {
                if (!st.isEmpty()) {
                    ans.append(c);
                }
                st.push(c);
            } else {
                // c == ')'
                st.pop();
                if (!st.isEmpty()) {
                    ans.append(c);
                }
            }
        } 
        
        return ans.toString(); 
    } 
}
