import java.util.Arrays;
import java.util.List;

class Solution {
    static class Element {
        long weight;
        int[] indices;

        Element(long weight, int[] indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    // Changed signature from int[][] to List<List<Integer>>
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) id[i] = i;
        
        // Sort indices based on interval start times: intervals.get(idx).get(0)
        Arrays.sort(id, (a, b) -> Integer.compare(intervals.get(a).get(0), intervals.get(b).get(0)));

        // dp[i][j] stores the best Element using a subset of intervals from id[i...n-1] with exactly j intervals
        Element[][] dp = new Element[n + 1][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 4; j++) {
                dp[i][j] = new Element(0, new int[0]);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int currId = id[i];
            int r = intervals.get(currId).get(1); // end time

            // Binary search to find the first interval starting strictly after current interval's end time
            int low = i + 1, high = n, nextIdx = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mid < n && intervals.get(id[mid]).get(0) > r) {
                    nextIdx = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (int j = 1; j <= 4; j++) {
                // Option 1: Skip the current interval
                Element skip = dp[i + 1][j];
                
                // Option 2: Take the current interval
                Element prev = dp[nextIdx][j - 1];
                long takeWeight = intervals.get(currId).get(2) + prev.weight; // weight
                
                // Construct lexicographically sorted index array for the 'take' option
                int[] takeIndices = new int[prev.indices.length + 1];
                System.arraycopy(prev.indices, 0, takeIndices, 0, prev.indices.length);
                takeIndices[takeIndices.length - 1] = currId;
                Arrays.sort(takeIndices);

                // Compare options
                if (takeWeight > skip.weight) {
                    dp[i][j] = new Element(takeWeight, takeIndices);
                } else if (skip.weight > takeWeight) {
                    dp[i][j] = skip;
                } else {
                    // Tie-breaker: choose lexicographically smaller index array
                    if (compareArrays(takeIndices, skip.indices) < 0) {
                        dp[i][j] = new Element(takeWeight, takeIndices);
                    } else {
                        dp[i][j] = skip;
                    }
                }
            }
        }

        return dp[0][4].indices;
    }

    private int compareArrays(int[] a, int[] b) {
        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            if (a[i] != b[i]) return Integer.compare(a[i], b[i]);
        }
        return Integer.compare(a.length, b.length);
    }
}
