class Solution { 
    public int largestRectangleArea(int[] h) { 
        int n = h.length; 
        Stack<Integer> st2 = new Stack<>(); 
        int pse[] = new int[n]; 
        int nse[] = new int[n]; 
        for (int i = n - 1; i >= 0; i--) { 
            while (!st2.isEmpty() && h[st2.peek()] >= h[i]) { 
                st2.pop(); 
            } 
            nse[i] = st2.isEmpty() ? n : st2.peek(); 
            st2.push(i); 
        } 
        st2.clear(); 
        for (int i = 0; i < n; i++) { 
            while (!st2.isEmpty() && h[st2.peek()] >= h[i]) { 
                st2.pop(); 
            } 
            pse[i] = st2.isEmpty() ? -1 : st2.peek(); 
            st2.push(i); 
        } 
        int max = 0; 
        for (int i = 0; i < n; i++) { 
            int carea = h[i] * (nse[i] - pse[i] - 1); 
            max = Math.max(max, carea); 
        } 
        return max; 
    } 
    public int maximalRectangle(char[][] matrix) { 
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int n = matrix.length; 
        int m = matrix[0].length; 
        int[] heights = new int[m]; 
        int max = 0; 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) { 
                if (matrix[i][j] == '1') {
                    heights[j] += 1; 
                } else {
                    heights[j] = 0;
                }
            } 
            int area = largestRectangleArea(heights); 
            max = Math.max(max, area); 
        } 
        return max; 
    } 
}
