class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int x=Math.min(n,m);
        int ans[]=new int[x];
        int idx=0;
        // Use a visited array to mark used elements in nums2
        boolean[] used = new boolean[m];

        for (int i = 0; i < n; i++) {
            int curr = nums1[i];
            for (int j = 0; j < m; j++) {
                if (!used[j] && curr == nums2[j]) {
                    ans[idx++] = curr;
                    used[j] = true; // mark nums2[j] as consumed
                    break;          // stop after first match
                }
            }
        }

        // Trim result to actual size
        int[] result = new int[idx];
        for (int i = 0; i < idx; i++) {
            result[i] = ans[i];
        }
        return result;
    }
}