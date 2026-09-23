class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n=arr.length;
        int l=0;
        int r=n-1;
        while(l<r){
            int sum=arr[l]+arr[r];
            if(sum==target) return new int[] {l+1,r+1};
            else if(sum>target){
                r--;
            }
            else{
                l++;
            }
        }
        return new int[] {-1,-1};
    }
}