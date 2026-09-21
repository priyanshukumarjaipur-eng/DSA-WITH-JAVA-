class Solution {
    public int[][] merge(int[][] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int n = arr.length;
        int[][] ans = new int[n][2];
        int idx = 0;
        ans[0][0] = arr[0][0];
        ans[0][1] = arr[0][1];
        for (int i = 1; i < n; i++) {
            if (arr[i][0] <= ans[idx][1]) {
                ans[idx][1] = Math.max(arr[i][1], ans[idx][1]);
            } else {
                idx++;
                ans[idx][0] = arr[i][0];
                ans[idx][1] = arr[i][1];
            }
        }
        return Arrays.copyOf(ans, idx + 1);
    }
}
