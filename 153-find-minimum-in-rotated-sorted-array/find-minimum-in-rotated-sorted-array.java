class Solution {
    public int findMin(int[] arr) {
        int n=arr.length;
        int i=0;
        int min=arr[0];
        while(i<n){
            if(arr[i]<min){
                min=arr[i];
            }
            i++;
        }
        return min;
    }
}