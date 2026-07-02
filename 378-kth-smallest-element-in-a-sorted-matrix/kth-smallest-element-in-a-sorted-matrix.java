class Solution {
    public int kthSmallest(int[][] arr, int k) {
        int n=arr.length;
        int m=arr[0].length;
     int ans[]=new int[n*m];
     int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[idx++] = arr[i][j];
            }
        }
        Arrays.sort(ans);
     return ans[k-1];
    }
}