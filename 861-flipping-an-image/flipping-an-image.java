class Solution {
    public static void reverse_r(int arr[][],int r){
        int i=0,j=arr[0].length-1;
        while(i<j){
            int temp=arr[r][i];
            arr[r][i]=arr[r][j];
            arr[r][j]=temp;
            i++;
            j--;
        }
    }
    public int[][] flipAndInvertImage(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            reverse_r(arr,i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    arr[i][j]=1;
                }
                else{
                    arr[i][j]=0;
                }
            }
        }
        return arr;
        }
    }
