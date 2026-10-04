class Solution {
    public boolean checkValidString(String s) {
        int n=s.length();
        int open=0;
        int close=0;
        int str=0;
        for(char c:s.toCharArray()){
            if(c=='(') open++;
            else if(c==')') close++;
            else str++;
            if (close > open + str) {
                return false; 
            }
        }
        open=0;
        close=0;
        str=0;
        char arr[]=s.toCharArray();
        for(int i=arr.length-1;i>=0;i--){
            char c=arr[i];
            if(c=='(') open++;
            else if(c==')') close++;
            else str++;

            if(open>close+str){
                return false;
            }
        }
        return true;
    }
}