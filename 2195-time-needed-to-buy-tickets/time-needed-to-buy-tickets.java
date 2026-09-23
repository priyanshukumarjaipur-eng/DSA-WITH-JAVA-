import java.util.*;

class pair { 
    int val; 
    int idx; 
    pair(int val, int idx) { 
        this.val = val; 
        this.idx = idx; 
    } 
}
class Solution { 
    public int timeRequiredToBuy(int[] tick, int k) { 
        Queue<pair> q = new LinkedList<>(); 
        int n = tick.length; 
        for (int i = 0; i < n; i++) { 
            q.add(new pair(tick[i], i)); 
        } 
        int ans = 0; 
        while (!q.isEmpty()) { 
            pair current = q.remove(); 
            current.val--;
            ans++; 
            if (current.val == 0 && current.idx == k) {
                return ans;
            }
            if (current.val > 0) {
                q.add(current);
            }
        } 
        return ans; 
    } 
}
