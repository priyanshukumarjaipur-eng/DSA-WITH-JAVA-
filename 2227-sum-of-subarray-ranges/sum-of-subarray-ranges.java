class Solution {
    public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();
        int nse[] = new int[n];
        int pse[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sum += left * right * arr[i];
        }
        return sum;
    }

    public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        long sum = 0;
        Stack<Integer> st = new Stack<>();
        int nge[] = new int[n];
        int pge[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            sum += left * right * arr[i];
        }
        return sum;
    }

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
    }
}
