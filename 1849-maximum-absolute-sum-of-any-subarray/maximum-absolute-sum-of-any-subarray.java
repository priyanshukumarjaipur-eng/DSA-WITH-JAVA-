class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;   // maximum subarray sum
        int minSum = 0;   // minimum subarray sum
        int currMax = 0;  // current max prefix sum
        int currMin = 0;  // current min prefix sum

        for (int num : nums) {
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }

        return Math.max(maxSum, -minSum);
    }
}
