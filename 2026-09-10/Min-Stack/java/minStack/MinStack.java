package minStack;

class MinStack {
    static class Node {
        int value;
        int prefixMin;
        Node next;

        // dummy node
        Node(){
            this.value = Integer.MAX_VALUE;
            this.prefixMin = Integer.MAX_VALUE;
            this.next = null;
        }

        Node( int value , int prefixMin , Node next ){
            this.value = value;
            this.prefixMin = prefixMin;
            this.next = next;
        }
    }

    private Node stack;

    public MinStack() {
        stack = new Node();
    }


    public void push(int value) {
        int minSoFar = Math.min( stack.prefixMin , value );
        stack = new Node(value,minSoFar,stack);
    }
    
    public void pop() {
        stack = stack.next;
    }
    
    public int top() {
        return stack.value;
    }
    
    public int getMin() {
        return stack.prefixMin;
    }
}