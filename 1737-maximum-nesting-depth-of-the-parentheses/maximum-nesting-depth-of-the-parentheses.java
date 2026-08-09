class Solution {
    public int maxDepth(String s) {
        int d=0,max=0;
        char x[]=s.toCharArray();
        for(char n:x){
            if(n=='('){
                d++;
            }
            max=Math.max(max,d);
            if(n==')'){
                d--;
            }
        }
        return max;
    }
}