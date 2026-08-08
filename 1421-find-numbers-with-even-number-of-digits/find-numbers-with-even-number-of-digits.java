class Solution {
    public int findNumbers(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<n;i++){
            int curr=nums[i];
            int count=0;
            while(curr>0){
                count++;
                curr=curr/10;
            }
            if(count%2==0){
                ans++;
            }
        }
        return ans;
    }
}