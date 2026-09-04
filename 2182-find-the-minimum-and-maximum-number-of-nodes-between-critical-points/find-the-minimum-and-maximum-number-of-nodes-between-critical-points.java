class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // Initialize the answer array to default values [-1, -1]
        int[] ans = {-1, -1};
        
        // Base case: a critical point requires at least 3 nodes
        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        int idx = 1;
        int fidx = -1; // First critical point index
        int lidx = -1; // Last critical point index
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;

        while (next != null) {
            // Check if current node is a local maxima or local minima
            if ((prev.val < curr.val && curr.val > next.val) || 
                (prev.val > curr.val && curr.val < next.val)) {
                
                // If it's the first critical point found
                if (fidx == -1) {
                    fidx = idx;
                }
                
                // If a previous critical point exists, calculate the distance
                if (lidx != -1) {
                    int dist = idx - lidx;
                    minDistance = Math.min(minDistance, dist);
                }
                
                // Update the last seen critical point index
                lidx = idx;
            }
            
            // Move to the next triplet
            idx++;
            prev = curr;
            curr = next;
            next = next.next;
        }

        // If fewer than two critical points were found
        if (fidx == lidx) {
            return ans;
        }

        // Calculate maximum distance and assign to the answer array
        int maxDistance = lidx - fidx;
        ans[0] = (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
        ans[1] = maxDistance;

        return ans;
    }
}