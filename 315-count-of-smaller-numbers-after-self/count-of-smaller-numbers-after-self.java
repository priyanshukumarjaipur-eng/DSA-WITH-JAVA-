class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] ansArr = new int[n];   // store counts for each index
        int[] idx = new int[n];      // track original indices
        for (int i = 0; i < n; i++) idx[i] = i;

        mergeSort(nums, idx, 0, n - 1, ansArr);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int count : ansArr) ans.add(count);
        return ans;
    }

    private void mergeSort(int[] nums, int[] idx, int left, int right, int[] ansArr) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, idx, left, mid, ansArr);
        mergeSort(nums, idx, mid + 1, right, ansArr);
        merge(nums, idx, left, mid, right, ansArr);
    }

    private void merge(int[] nums, int[] idx, int left, int mid, int right, int[] ansArr) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[idx[j]] < nums[idx[i]]) {
                temp[k++] = idx[j++];
                rightCount++;
            } else {
                ansArr[idx[i]] += rightCount;
                temp[k++] = idx[i++];
            }
        }
        while (i <= mid) {
            ansArr[idx[i]] += rightCount;
            temp[k++] = idx[i++];
        }
        while (j <= right) {
            temp[k++] = idx[j++];
        }
        for (int p = 0; p < temp.length; p++) {
            idx[left + p] = temp[p];
        }
    }
}
