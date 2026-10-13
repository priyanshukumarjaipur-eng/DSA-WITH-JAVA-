import java.util.Arrays;

class Solution { 
    public long maxAlternatingSum(int[] nums) { 
        int n = nums.length; 
        long[] square = new long[n]; 
        for(int i = 0; i < n; i++){ 
            square[i] = (long)nums[i] * nums[i]; 
        } 
        Arrays.sort(square); 
        long score = 0; 
        
        int negativeSlots = n / 2;
        for(int i = 0; i < n; i++){ 
            if (i < negativeSlots) {
                score -= square[i];
            } else {
                score += square[i];
            }
        } 
        return score; 
    } 
}
