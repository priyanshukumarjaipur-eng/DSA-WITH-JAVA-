class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] freq = new int[k]; 
        freq[0] = 1; // base case: empty prefix remainder
        
        int prefix = 0, count = 0;
        
        for (int num : nums) {
            prefix += num;
            int mod = ((prefix % k) + k) % k; // normalize negative remainders
            
            count += freq[mod];   // add all previous subarrays with same remainder
            freq[mod]++;          // update frequency
        }
        
        return count;
    }
}
