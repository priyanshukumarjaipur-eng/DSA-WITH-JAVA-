class Solution {
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public int firstMissingPositive(int[] arr) {
        int i=0;
        int n=arr.length;
        while(i<n){
            int ridx=arr[i]-1;
            if(arr[i]<=0 ||arr[i]>n || arr[i]==i+1 || arr[ridx]==arr[i]) i++;
            else{
                swap(arr,i,ridx);
            }
        }
        for(i=0;i<n;i++){
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}