class Solution {
    public static int max(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    }
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (n == k)  return max(nums);
        int[] freq = new int[51];
        for (int num : nums) {
            freq[num]++;
        }
        if (k == 1) {
            int maxUnique = -1;
            for (int num : nums) {
                if (freq[num] == 1) {
                    maxUnique = Math.max(maxUnique, num);
                }
            }
            return maxUnique;
        }
        int firstElement = nums[0];
        int lastElement = nums[n - 1];
        
        int result = -1;
        if (freq[firstElement] == 1) {
            result = Math.max(result, firstElement);
        }
        if (freq[lastElement] == 1) {
            result = Math.max(result, lastElement);
        }
        return result;
    }
}
