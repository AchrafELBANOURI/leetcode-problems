package onlineStockSpan;

class StockSpanner {
    private int[] stack;
    private int top;

    private int[] next;

    private final int DEFAULT_CAPACITY = 10_000;

    public StockSpanner() {
        stack = new int[DEFAULT_CAPACITY];
        next = new int[DEFAULT_CAPACITY];
        top = 0;
    }

    public int next(int price) {
        int result = 0 ;
        while( top > 0 && stack[top-1] <= price ){
            result += next[--top];
        }

        result+=1;

        stack[top] = price;
        next[top] = result;
        top++;

        return result;
    }
}