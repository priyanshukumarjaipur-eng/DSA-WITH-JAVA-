class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        int i=0;
        while(i<n-1){
            if(nums[i]==nums[i+1]){
                ans.add(nums[i]);
                i+=2;
            }
            else{
                i++;
            }
        }
        return ans;
    }
}