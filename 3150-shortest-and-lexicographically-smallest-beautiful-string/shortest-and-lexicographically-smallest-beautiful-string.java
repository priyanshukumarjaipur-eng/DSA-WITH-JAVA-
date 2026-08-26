class Solution { 
    // Fix 1: Properly compare strings using compareTo()
    public static boolean compare(String s1, String s2) { 
        if (s1.length() != s2.length()) { 
            return s1.length() < s2.length(); 
        } 
        return s1.compareTo(s2) < 0; 
    } 

    public String shortestBeautifulSubstring(String s, int k) { 
        int n = s.length(); 
        int one = 0; 
        for (int i = 0; i < n; i++) { 
            if (s.charAt(i) == '1') one++; 
        } 
        if (one < k) return ""; 
        one = 0; 
        String ans = ""; 
        int l = 0; 

        for (int r = 0; r < n; r++) { 
            if (s.charAt(r) == '1') one++; 
            while (one == k) {
                String sub = s.substring(l, r + 1);
                if (ans.equals("") || compare(sub, ans)) {
                    ans = sub;
                }
                if (s.charAt(l) == '1') one--;
                l++;
            }
        } 
        return ans; 
    } 
}
