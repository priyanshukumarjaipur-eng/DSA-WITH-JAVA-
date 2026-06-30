class Solution {
    public static void transpose(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
    }
    public static void reverse_row(int arr[][],int r){
        int j=arr[0].length-1,i=0;
        while(i<j){
            int temp=arr[r][i];
            arr[r][i]=arr[r][j];
            arr[r][j]=temp;
            i++;
            j--;
        }

    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
       for(int i=0;i<matrix.length;i++){
         reverse_row(matrix,i);
       }
    }
}