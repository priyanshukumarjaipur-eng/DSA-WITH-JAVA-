import java.util.Arrays;

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLeft = new int[n];
        int[] minRight = new int[n];
        Arrays.fill(minLeft, Integer.MAX_VALUE);
        Arrays.fill(minRight, Integer.MAX_VALUE);

        // 1. Left-to-Right Pass
        int l = 0, sum = 0, currentMin = Integer.MAX_VALUE;
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                currentMin = Math.min(currentMin, r - l + 1);
            }
            minLeft[r] = currentMin;
        }

        // 2. Right-to-Left Pass
        int right = n - 1, rSum = 0;
        currentMin = Integer.MAX_VALUE;
        for (int left = n - 1; left >= 0; left--) {
            rSum += arr[left];
            while (rSum > target) {
                rSum -= arr[right];
                right--;
            }
            if (rSum == target) {
                currentMin = Math.min(currentMin, right - left + 1);
            }
            minRight[left] = currentMin;
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            if (minLeft[i] != Integer.MAX_VALUE && minRight[i + 1] != Integer.MAX_VALUE) {
                minSum = Math.min(minSum, minLeft[i] + minRight[i + 1]);
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
