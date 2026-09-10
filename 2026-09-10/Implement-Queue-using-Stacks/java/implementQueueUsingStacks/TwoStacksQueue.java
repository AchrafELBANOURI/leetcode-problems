package implementQueueUsingStacks;

import java.util.Stack;

public class TwoStacksQueue implements QueueI{
    private Stack<Integer> stack ;
    private Stack<Integer> swap;

    public TwoStacksQueue() {
        stack = new Stack<>();
        swap  = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        int n = stack.size();
        for(int i = 0 ; i < n-1 ; i++ ){
            swap.push(stack.pop());
        }
        int top = stack.pop();
        for(int i = 0 ; i < n-1 ; i++ ){
            stack.push(swap.pop());
        }
        swap = new Stack<>();
        return top;
    }
    
    public int peek() {
        int n = stack.size();
        for(int i = 0 ; i < n-1 ; i++ ){
            swap.push(stack.pop());
        }
        int top = stack.pop();
        swap.push(top);
        for(int i = 0 ; i < n ; i++ ){
            stack.push(swap.pop());
        }
        swap = new Stack<>();
        return top;
    }
    
    public boolean empty() {
        return stack.empty();
    }
}
