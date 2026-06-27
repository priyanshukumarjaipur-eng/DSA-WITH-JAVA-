class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo=0;
        int n=arr.length;
        int hi=n-1;
        int mid=0;
        while(lo<hi){
             mid=(lo+hi)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return mid;
    }
}