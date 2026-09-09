class Solution {
    public long countCommas(long n) {
        if (n <= 999) return 0;

        long totalCommas = 0;
        long start = 1000;

        while (start <= n) {
            totalCommas += n - start + 1;
            
            // Prevent overflow before multiplying by 1000
            if (start > Long.MAX_VALUE / 1000) {
                break;
            }
            start *= 1000;
        }

        return totalCommas;
    }
}
