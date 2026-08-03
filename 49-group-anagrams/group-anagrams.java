import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>(); 
        boolean[] visited = new boolean[n];         
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;                
            
            List<String> x = new ArrayList<>();    
            x.add(strs[i]);                         
            visited[i] = true;
            
            for (int j = i + 1; j < n; j++) {
                if (visited[j]) continue;            
                if (isAnagram(strs[i], strs[j])) {
                    x.add(strs[j]);
                    visited[j] = true;              
                }
            }
            ans.add(x);                            
        }
        return ans;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
