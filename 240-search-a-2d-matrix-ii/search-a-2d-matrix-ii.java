class Solution {
    public boolean searchMatrix(int[][] arr, int tar) {
        int n = arr.length;
        int m = arr[0].length;
        int row = 0, col = m - 1; 

        while (row < n && col >= 0) {
            if (arr[row][col] == tar) return true;
            else if (arr[row][col] > tar) col--; 
            else row++; 
        }
        return false;
    }
}
