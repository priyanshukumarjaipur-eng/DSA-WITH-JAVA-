class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        boolean[] seen1 = new boolean[101];
        boolean[] seen2 = new boolean[101];
        int count1 = 0;
        int count2 = 0;

        for (int num : nums1) {
            seen1[num] = true;
        }

        for (int num : nums2) {
            seen2[num] = true;
        }

        for (int num : nums1) {
            if (seen2[num]) {
                count1++;
            }
        }

        for (int num : nums2) {
            if (seen1[num]) {
                count2++;
            }
        }

        return new int[] { count1, count2 };
    }
}