class Solution { 
    public int scoreOfParentheses(String s) { 
        int n = s.length(); 
        Stack<Character> st = new Stack(); 
        int count = 0; 
        int depth = 0; 
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if(c == '(') { 
                st.push(c); 
                depth++; 
            } 
            if(c == ')') { 
                depth--; 
                if(s.charAt(i - 1) == '(' && st.peek() == '(') { 
                    // Instead of just count++, we add 2^depth
                    count += Math.pow(2, depth); 
                } 
                st.pop(); 
            } 
        } 
        return count; 
    } 
}
