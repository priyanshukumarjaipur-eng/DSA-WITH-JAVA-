class CustomStack {
    Stack<Integer> st;
    int maxSize;

    public CustomStack(int maxSize) {
        st = new Stack<>();
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (st.size() < maxSize) {
            st.push(x);
        }
    }
    
    public int pop() {
        if (!st.isEmpty()) {
            return st.pop();
        }
        return -1;
    }
    
    public void increment(int k, int val) {
        int n = st.size();
        int[] arr = new int[n];
        
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = st.pop();
        }
        
        int elementsToIncrement = Math.min(k, n);
        for (int i = 0; i < elementsToIncrement; i++) {
            arr[i] += val;
        }
        
        for (int i = 0; i < n; i++) {
            st.push(arr[i]);
        }
    }
}
