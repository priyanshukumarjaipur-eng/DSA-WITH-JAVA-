class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        int sidx=0;
        int ans=0;
        for(int i=0;i<n;i++){
            int x=nums[i];
            while(x>0){
                ans+=x%10;
                x=x/10;
            }
            if(ans==i) return i;
            ans=0;
        }
        return -1;
    }
}