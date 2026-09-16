class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        boolean[] toRemove = new boolean[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else if (c == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    toRemove[i] = true;
                }
            }
        }
        while (!st.isEmpty()) {
            toRemove[st.pop()] = true;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!toRemove[i]) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
