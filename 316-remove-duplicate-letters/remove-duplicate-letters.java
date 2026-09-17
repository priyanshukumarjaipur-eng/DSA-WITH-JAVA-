class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        boolean seen[] = new boolean[26]; 
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';
            count[idx]--;  
            if (seen[idx]) {
                continue;
            }
            while (!st.isEmpty() && st.peek() > c && count[st.peek() - 'a'] > 0) {
                char removed = st.pop();
                seen[removed - 'a'] = false;
            }
            st.push(c);
            seen[idx] = true;
        }
        String ans = "";
        while (!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        return ans;
    }
}
