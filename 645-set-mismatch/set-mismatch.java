class Solution {
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int[] findErrorNums(int[] nums) {
        int n=nums.length;
       int ans[]=new int[2];
        int i=0;
        while(i<n){
            int ridx=nums[i]-1;
            if(nums[i]==i+1 || nums[ridx]==nums[i]) i++;
            else{
                swap(nums,i,ridx);
            }
        }
        int x=0;
        for(i=0;i<n;i++){
            if(nums[i]!=i+1){
                ans[x++]=nums[i];
                ans[x++]=i+1;
            }
        }
        return ans;   
    }
}