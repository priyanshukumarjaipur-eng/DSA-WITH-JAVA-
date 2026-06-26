class Solution {
    public int[] searchRange(int[] arr, int target) {
        int f=-1;
        int l=-1;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==target){
                if(f==-1) f=i;
                l=i;
            }
        }
        return new int[] {f,l};
    }
}