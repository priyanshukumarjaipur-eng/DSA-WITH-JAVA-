class Solution {
    public int[] runningSum(int[] nums) {
     int n=nums.length;
          int prev=nums[0];
     for(int i=0;i<n;i++){
        if(i!=0){
        int curr=nums[i];
        nums[i]=curr+prev;
        }
        prev=nums[i];
     }   
     return nums;
    }
}