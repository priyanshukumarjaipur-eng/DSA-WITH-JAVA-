class Solution {
    public long countSubstrings(String s, char c) {
        long count = 0;
        
        // Count total occurrences of character 'c'
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        
        // Apply the combination formula: k * (k + 1) / 2
        return (count * (count + 1)) / 2;
    }
}
