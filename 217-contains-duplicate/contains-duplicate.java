class Solution {
    public boolean containsDuplicate(int[] nums) {
     int n=nums.length;
     int i=0;
     Arrays.sort(nums);
     while(i<(n-1)){
        if(nums[i]==nums[i+1]){
            return true;
        }
        i++;
     }
     return false;
    }
}