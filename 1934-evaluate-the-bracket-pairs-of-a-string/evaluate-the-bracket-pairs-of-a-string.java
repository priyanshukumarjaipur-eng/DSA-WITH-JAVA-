class Solution { 
    public String evaluate(String s, List<List<String>> k) { 
        Collections.sort(k, (a, b) -> a.get(0).compareTo(b.get(0)));
        int n = s.length(); 
        Stack<Integer> st = new Stack<>(); 
        int i = 0;         
        for (char c : s.toCharArray()) { 
            if (c == '(') { 
                st.push(i + 1); 
            } else if (c == ')') { 
                st.push(i); 
            } 
            i++; 
        } 
        while (!st.isEmpty()) { 
            int a = st.pop(); 
            int b = st.pop(); 
            String key = s.substring(b, a);   
            String replacement = "?"; 
            int low = 0, high = k.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int cmp = k.get(mid).get(0).compareTo(key);
                if (cmp == 0) {
                    replacement = k.get(mid).get(1);
                    break;
                } else if (cmp < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            s = s.substring(0, b - 1) + replacement + s.substring(a + 1); 
        } 
        return s; 
    } 
}
