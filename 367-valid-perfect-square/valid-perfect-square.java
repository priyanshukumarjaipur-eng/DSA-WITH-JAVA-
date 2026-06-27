class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1, j = num;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            long sq = (long) mid * mid;
            if (sq == num) return true;
            else if (sq > num) j = mid - 1;  // simpler check
            else i = mid + 1;
        }
        return false;
    }
}
