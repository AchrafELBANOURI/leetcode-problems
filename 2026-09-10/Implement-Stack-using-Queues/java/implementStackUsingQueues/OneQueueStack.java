package implementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class OneQueueStack implements StackI {
    private Queue<Integer> queue;

    public OneQueueStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        int n = queue.size();
        for( int i = 0 ; i < n-1 ; i++){
            queue.offer(queue.poll());
        }
        return queue.poll();   
    }
    
    public int top() {
        int n = queue.size();
        for( int i = 0 ; i < n-1 ; i++){
            queue.offer(queue.poll());
        }
        int top = queue.poll();
        queue.offer(top);
        return top;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
