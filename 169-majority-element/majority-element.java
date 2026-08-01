class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]){
                    sum++;
                }
            }
            if(sum>=n/2){
                max=nums[i];
            }
        }
        return max;
    }
}