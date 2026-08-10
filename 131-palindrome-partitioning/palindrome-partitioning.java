class Solution { 
    // FIXED: Changed return type to boolean, fixed the else-block bug, and fixed bounds
    public static boolean check(String s, int i, int j) { 
        while (i < j) { // Changed <= to < (no need to compare a character with itself)
            if (s.charAt(i) != s.charAt(j)) { 
                return false; 
            }
            i++; 
            j--; 
        } 
        return true; // FIXED: Only return true after checking ALL characters
    } 

    public List<List<String>> partition(String s) { 
        List<List<String>> ans = new ArrayList<>(); 
        List<String> x = new ArrayList<>(); 
        
        // Start the recursive process from index 0
        solve(s, 0, x, ans);
        return ans;
    } 

    // FIXED: Replaced your while loop with a recursive backtracking loop to find all paths
    private void solve(String s, int i, List<String> x, List<List<String>> ans) {
        // Base case: If we reached the end of the string, save the successful partition
        if (i == s.length()) {
            ans.add(new ArrayList<>(x));
            return;
        }

        // Loop through all possible ending points (j) for the current substring
        for (int j = i; j < s.length(); j++) {
            if (check(s, i, j)) { 
                x.add(s.substring(i, j + 1)); // Add the valid palindrome substring
                solve(s, j + 1, x, ans);      // Move to the next index
                x.remove(x.size() - 1);       // Remove it to try other combinations
            } 
        } 
    }
}
