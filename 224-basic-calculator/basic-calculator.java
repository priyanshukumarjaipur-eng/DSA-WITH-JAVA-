class Solution {
    public int calculate(String s) {
        int n=s.length();
        int ans=0;
        int sign=1;
        int curr=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                curr=c-'0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) { 
                    curr = (curr * 10) + (s.charAt(i + 1) - '0'); 
                    i++; 
                }
                curr=curr*sign;
                ans+=curr;
                curr=0;
            }
            else if(c=='+'){
                sign=1;
            }
            else if(c=='-'){
                sign=-1;
            }
            else if(c=='('){
                st.push(ans);
                st.push(sign);
                ans=0;
                sign=1;
            }
            else if(c==')'){
                int psign=st.pop();
                ans=ans*psign;
                int pans=st.pop();
                ans+=pans;
            }
        }
        return ans;
    }
}