class Solution {
    public int minLength(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            char c=s.charAt(i);
            if(!st.isEmpty() && c=='C' && st.peek()=='D'){
                st.pop();
                continue;
            }
            else if(!st.isEmpty() && c=='A' && st.peek()=='B'){
                st.pop();
                continue;
            }
            st.push(c);
        }
        return st.size();
    }
}