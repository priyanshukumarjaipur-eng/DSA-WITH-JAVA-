class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = (double) sum / k;

        // Slide the window
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            double avg = (double) sum / k;
            max = Math.max(max, avg);
        }

        return max;
    }
}
