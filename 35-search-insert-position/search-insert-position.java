class Solution {
    public int searchInsert(int[] nums, int target) {
        int idx=0;
        int i=0;
        int n=nums.length;
        int j=n-1;
        while(i<n){
            if(nums[i]==target){
                idx=i;
            }
            else if(nums[i]<target){
                idx=i+1;
            }
            i++;
        }
        return idx;
    }
}