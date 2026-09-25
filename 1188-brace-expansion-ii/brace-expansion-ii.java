import java.util.*;

public class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(expression);
        Set<String> resultSet = new TreeSet<>();
        
        while (!queue.isEmpty()) {
            String exp = queue.poll();
            
            if (!exp.contains("{")) {
                resultSet.add(exp);
                continue;
            }
            
            int right = 0;
            while (exp.charAt(right) != '}') {
                right++;
            }
            
            int left = right;
            while (exp.charAt(left) != '{') {
                left--;
            }
            
            String before = exp.substring(0, left);
            String inside = exp.substring(left + 1, right);
            String after = exp.substring(right + 1);
            
            String[] options = inside.split(",");
            
            for (String option : options) {
                StringBuilder sb = new StringBuilder();
                sb.append(before).append(option).append(after);
                queue.offer(sb.toString());
            }
        }
        
        return new ArrayList<>(resultSet);
    }
}
