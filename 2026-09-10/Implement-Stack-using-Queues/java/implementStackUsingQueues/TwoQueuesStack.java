package implementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueuesStack implements StackI{
    // Heavy-Pop
    Queue<Integer> queue;
    Queue<Integer> swap;

    public TwoQueuesStack() {
        this.queue = new LinkedList<>();
        this.swap = new LinkedList<>();
    }
    
    @Override
    public void push(int x) {
        queue.offer(x);
    }
    
    @Override
    public int pop() {
        int n = queue.size();
        for(int i = 0 ; i < n-1 ; i++ ){
            swap.offer(queue.poll());

        }
        int top = queue.poll();
        queue = swap;
        swap = new LinkedList<>();
        return top;
        
    }
    
    @Override
    public int top() {
        int n = queue.size();
        for(int i = 0 ; i < n-1 ; i++ ){
            swap.offer(queue.poll());

        }
        int top = queue.poll();
        swap.offer(top);
        queue = swap;
        swap = new LinkedList<>();
        return top;

    }
    
    @Override
    public boolean empty() {
        return queue.isEmpty();
    }
}
