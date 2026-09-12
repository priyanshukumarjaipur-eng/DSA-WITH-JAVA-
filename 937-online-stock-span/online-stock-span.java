class StockSpanner {
    private class Pair {
        int val;
        int idx;
        
        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    private Stack<Pair> st;
    private int curIdx; 

    public StockSpanner() {
        st = new Stack<>();
        curIdx = 0; 
    }
    public int next(int price) {
        while (!st.isEmpty() && st.peek().val <= price) {
            st.pop();
        }
        int span = (st.isEmpty()) ? (curIdx + 1) : (curIdx - st.peek().idx);
        st.push(new Pair(price, curIdx));
        curIdx++;
        
        return span;
    }
}
