class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        int[] targetMap = new int[128];
        for (char c : t.toCharArray()) {
            targetMap[c]++;
        }
        
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int count = t.length();
        
        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (targetMap[rChar] > 0) {
                count--;
            }
            targetMap[rChar]--;
            right++;
            
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                
                char lChar = s.charAt(left);
                targetMap[lChar]++;
                if (targetMap[lChar] > 0) {
                    count++;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
