class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        int i=0,j=n-1;
       while(i<j){
            int prefix=nums[i];
            int sufix=nums[j];
            int sum=prefix+sufix;
            if(sum==k){
                count++;
            i++;
            j--;
            }
            else if(sum<k){
                i++;
            }
            else{
                j--;
            }
           
        }
        return count;
    }
}