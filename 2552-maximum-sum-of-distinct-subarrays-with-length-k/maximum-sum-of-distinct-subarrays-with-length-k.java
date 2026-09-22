class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long currentSum = 0;
        int[] freq = new int[100001]; 
        int left = 0;
        int duplicateCount = 0;
        for (int right = 0; right < n; right++) {
            int rightNum = nums[right];
            freq[rightNum]++;
            currentSum += rightNum;
            if (freq[rightNum] == 2) {
                duplicateCount++;
            }

            if (right - left + 1 > k) {
                int leftNum = nums[left];
                
                if (freq[leftNum] == 2) {
                    duplicateCount--;
                }
                
                freq[leftNum]--;
                currentSum -= leftNum;
                left++;
            }

            if (right - left + 1 == k && duplicateCount == 0) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}
