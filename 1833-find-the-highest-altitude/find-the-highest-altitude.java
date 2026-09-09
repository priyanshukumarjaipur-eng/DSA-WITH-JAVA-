class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int alt[]=new int[n+1];
        alt[0]=0;
        alt[1]=gain[0];
        int idx=2;
        for(int i=1;i<n;i++){
            alt[idx++]=gain[i]+alt[i];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<idx;i++){
            if(alt[i]>max){
                max=alt[i];
            }
        }
        return max;
    }
}