class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        int ans=n;
        Stack<Character>st=new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='('){
                st.push(c);
            }
            else{
                if (!st.isEmpty() && st.peek() == '(') {
                st.pop();
                ans-=2;
                }
            }
        }
        return ans;
    }
}