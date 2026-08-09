class Solution {
    public int maximumGap(int[] nums) {
     Arrays.sort(nums);
     int n=nums.length;
     int maxgap=0;
     for(int i=0;i<n-1;i++){
        int currentgap=nums[i+1]-nums[i];
        maxgap=Math.max(currentgap,maxgap);
     }
     return maxgap;   
    }
}