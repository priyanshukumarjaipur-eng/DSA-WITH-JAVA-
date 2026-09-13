class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums); 
        int maxc = 1;
        int count = 1; 
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i+1]) {
                continue; 
            }
            if (nums[i] + 1 == nums[i+1]) {
                count++;
            } else {
                maxc = Math.max(maxc, count);
                count = 1;
            }
        }
        return Math.max(maxc, count);
    }
}
