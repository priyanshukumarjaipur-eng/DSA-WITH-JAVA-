import java.util.Arrays;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        // Collect frequencies
        int[] c = new int[n];
        int idx = 0;
        for (int i = 0; i < n;) {
            int count = 1;
            while (i + 1 < n && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }
            c[idx++] = count;
            i++;
        }

        // Only keep the filled part of c
        int[] freq = Arrays.copyOf(c, idx);
        Arrays.sort(freq);

        // Check for duplicates
        for (int i = 0; i < freq.length - 1; i++) {
            if (freq[i] == freq[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
