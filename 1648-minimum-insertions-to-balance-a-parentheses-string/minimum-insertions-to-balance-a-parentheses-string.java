import java.util.Stack;

class Solution { 
    public int minInsertions(String s) { 
        Stack<Character> st = new Stack<>(); 
        int n = s.length(); 
        int ans = 0; 
        for (int i = 0; i < n; i++) { 
            char c = s.charAt(i); 
            if (c == '(') { 
                st.push('('); 
            } else { 
                if (i + 1 < n && s.charAt(i + 1) == ')') { 
                    i++; 
                } else { 
                    ans++; 
                } 
                
                if (!st.isEmpty() && st.peek() == '(') { 
                    st.pop(); 
                } else { 
                    ans++; 
                } 
            } 
        } 
        ans += st.size() * 2; 
        return ans; 
    } 
}
