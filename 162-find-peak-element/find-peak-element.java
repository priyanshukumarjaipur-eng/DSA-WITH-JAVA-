class Solution {
    public int findPeakElement(int[] arr) {
        int peak=arr[0];
        int n=arr.length;
        int i=1;
        int pid=0;
        while(i<n){
            if(arr[i]>peak){
                peak=arr[i];
                pid=i;
            }
            i++;
        }
        return pid;
    }
}