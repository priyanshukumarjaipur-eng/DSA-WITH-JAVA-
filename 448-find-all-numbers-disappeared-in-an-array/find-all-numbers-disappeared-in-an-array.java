class Solution {
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        while(i<n){
            int ridx=nums[i]-1;
            if(nums[i]==i+1 || nums[ridx]==nums[i]) i++;
            else{
                swap(nums,i,ridx);
            }
        }
        for(i=0;i<n;i++){
            if(nums[i]!=i+1){
                ans.add(i+1);
            }
        }
        return ans;    
    }
}