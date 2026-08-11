class Solution {
    public static void swap(int a,int b,int arr[]){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1] ){
            i--;
        }
        if(i>=0){
            int j=n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(i,j,nums);
        }
        int start = i + 1;
        int end = n - 1;
        while (start < end) {
            swap(start, end, nums);
            start++;
            end--;
        }

    }
}