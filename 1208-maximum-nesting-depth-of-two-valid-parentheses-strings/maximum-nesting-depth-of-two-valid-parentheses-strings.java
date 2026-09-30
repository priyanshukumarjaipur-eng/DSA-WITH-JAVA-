class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int ans[]=new int[n];
        int vps=0;
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                ans[i]=vps%2;
                vps++;
            }
            else if(seq.charAt(i)==')'){
                vps--;
                ans[i]=vps%2;;
            }
        }
        return ans;
    }
}