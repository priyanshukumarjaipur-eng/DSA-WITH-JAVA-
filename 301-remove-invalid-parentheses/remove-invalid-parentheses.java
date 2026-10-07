import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();
        backtrack(s, 0, 0, '(', ')', results);
        return results;
    }

    private void backtrack(String currentStr, int scanStart, int deleteStart, 
                           char openChar, char closeChar, List<String> results) {
        
        int balance = 0;
        
        for (int i = scanStart; i < currentStr.length(); i++) {
            char curr = currentStr.charAt(i);
            if (curr == openChar) balance++;
            else if (curr == closeChar) balance--;
            
            if (balance >= 0) continue;
            
            for (int j = deleteStart; j <= i; j++) {
                if (currentStr.charAt(j) == closeChar) {
                    if (j == deleteStart || currentStr.charAt(j - 1) != closeChar) {
                        String nextStr = currentStr.substring(0, j) + currentStr.substring(j + 1);
                        backtrack(nextStr, i, j, openChar, closeChar, results);
                    }
                }
            }
            return;
        }
        
        String reversed = new StringBuilder(currentStr).reverse().toString();
        
        if (openChar == '(') {
            backtrack(reversed, 0, 0, ')', '(', results);
        } else {
            results.add(reversed);
        }
    }
}
