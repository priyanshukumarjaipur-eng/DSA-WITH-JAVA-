class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int zero=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero++;
            }
            while(zero>k){
                if(nums[l]==0){
                    zero--;
                }
                l++;
            }
        max=Math.max(max,i-l+1);
        }
        return max;
    }
}