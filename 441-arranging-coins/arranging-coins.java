class Solution {
    public int sqrt(long n){
        if(n==0) return 0;
        long i=0,j=n;
        while(i<=j){
            long mid=i+(j-i)/2;
            if(mid==n/mid) return (int)mid;
            else if(mid>n/mid) j=mid-1;
            else i=mid+1;
        }
        return (int)j;
    }
    public int arrangeCoins(int n) {
        long m=(long)n;
        return (sqrt(8*m+1)-1)/2;
    }
}