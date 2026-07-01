class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int total =0;
       int maxs=nums[0],mins=nums[0];
       int curmax=0,curmin=0;
       for(int n: nums){
        curmax=Math.max(curmax+n,n);
        maxs=Math.max(maxs,curmax);
        curmin=Math.min(curmin+n,n);
        mins=Math.min(mins,curmin);
        total+=n;
       }
       if(maxs<0) return maxs;
        return Math.max(maxs,total-mins);
    }
}