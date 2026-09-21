class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int sum = 0;
        long MOD = 1_000_000_007;
        Stack<Integer> q = new Stack<>(); 
        for (int i = 0; i <= n; i++) {
            int min = (i == n) ? -1 : arr[i]; 
            while (!q.isEmpty() && min < arr[q.peek()]) {
                int j = q.pop(); 
                int leftBound = q.isEmpty() ? -1 : q.peek();
                long count = (long) (j - leftBound) * (i - j);
                sum = (int) ((sum + (count * arr[j])) % MOD);
            }
            q.push(i);
        }
        return sum;
    }
}
