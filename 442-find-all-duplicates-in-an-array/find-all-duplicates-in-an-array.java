class Solution {
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
    }
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        int n=arr.length;
        while(i<n){
            int ridx=arr[i]-1;
            if(arr[i]==i+1 || arr[ridx]==arr[i]) i++;
            else{
                swap(arr,i,ridx);
            }
        }
        for(int x=0;x<n;x++){
            if(arr[x]!=x+1){
                ans.add(arr[x]);
            }
        }
        return ans;
    }
}