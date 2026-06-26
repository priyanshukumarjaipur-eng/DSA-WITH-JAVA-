class Solution {
    public int search(int[] arr, int target) {
     int n=arr.length;
     int i=0,j=n-1;
     while(i<=j){
        int mid=(i+j)/2;
        if(arr[mid]>target){
            j=mid-1;
        }
        else if(arr[mid]<target){
            i=mid+1;
        }
        else if(arr[mid]==target){
            return mid;
        }
     } 
     return -1;  
    }
}