class Solution {
    public static boolean isgreater(int nums[]){
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                count++;
            }
        }
        if(count==nums.length-1) return true;
        return false;
    }
      public static boolean issmaller(int nums[]){
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<=nums[i+1]){
                count++;
            }
        }
        if(count==nums.length-1) return true;
        return false;
    }
    public boolean isMonotonic(int[] nums) {
        if(isgreater(nums) || issmaller(nums)){
            return true;
        }
        return false;
    }
}