class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> distinct1 = new ArrayList<>();
        List<Integer> distinct2 = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length) {
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }
            while (j < nums2.length && nums2[j] < nums1[i]) {
                j++;
            }
            if (j == nums2.length || nums2[j] != nums1[i]) {
                distinct1.add(nums1[i]);
            }
            i++;
        }
        i = 0; j = 0;
        while (j < nums2.length) {
            if (j > 0 && nums2[j] == nums2[j - 1]) {
                j++;
                continue;
            }
            while (i < nums1.length && nums1[i] < nums2[j]) {
                i++;
            }
            if (i == nums1.length || nums1[i] != nums2[j]) {
                distinct2.add(nums2[j]);
            }
            j++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(distinct1);
        ans.add(distinct2);
        return ans;
    }
}
