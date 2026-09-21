class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] dp = new long[k];
        long[] ans = new long[k];
        for (int num : nums) {
            long[] newdp = new long[k];
            int currentMod = ((num % k) + k) % k;
            newdp[currentMod]++;
            for (int i = 0; i < k; i++) {
                if (dp[i] > 0) {
                    int newRem = (int) (((long) i * currentMod) % k);
                    newdp[newRem] += dp[i];
                }
            }
            for (int i = 0; i < k; i++) {
                ans[i] += newdp[i];
            }
            
            dp = newdp;
        }
        
        return ans;
    }
}
