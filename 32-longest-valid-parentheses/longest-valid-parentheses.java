class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        String ans = "";
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    int currentLen = i - st.peek();
                    if (currentLen > ans.length()) {
                        ans = " ".repeat(currentLen);
                    }
                }
            }
        }

        return ans.length();
    }
}
