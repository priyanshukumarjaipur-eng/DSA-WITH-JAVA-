class MyQueue {
    Stack<Integer> queue;
    public MyQueue() {
        queue=new Stack<>();
    }
// helper function 
   public void reverse(Stack<Integer> stack) {
    Stack<Integer> temp1 = new Stack<>();
    Stack<Integer> temp2 = new Stack<>();
    
    while (!stack.isEmpty()) {
        temp1.push(stack.pop());
    }
    while (!temp1.isEmpty()) {
        temp2.push(temp1.pop());
    }
    while (!temp2.isEmpty()) {
        stack.push(temp2.pop());
    }
}

    public void push(int x) {
        queue.push(x);
    }
    
    public int pop() {
        reverse(queue);
        int p=queue.pop();
        reverse(queue);
        return p;
    }
    
    public int peek() {
        reverse(queue);
        int peak=queue.peek();
        reverse(queue);
        return peak;
    }
    
    public boolean empty() {
        if(queue.size()==0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */