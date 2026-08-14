class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int l = 0;

        // Make a copy and sort it
        int[] temp = nums.clone();
        Arrays.sort(temp);

        // Remove duplicates
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || temp[i] != temp[i - 1]) {
                temp[m++] = temp[i];
            }
        }

        // Frequency array
        int[] freq = new int[m];

        for (int i = 0; i < n; i++) {
            // Find index of nums[i] in compressed array
            int index = Arrays.binarySearch(temp, 0, m, nums[i]);
            freq[index]++;

            // Shrink window if frequency exceeds k
            while (freq[index] > k) {
                int leftIndex = Arrays.binarySearch(temp, 0, m, nums[l]);
                freq[leftIndex]--;
                l++;
            }

            max = Math.max(max, i - l + 1);
        }

        return max;
    }
}