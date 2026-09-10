package maximumFrequencyStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class FreqStack {

    Map<Integer,Stack<Integer>> frequencyLevels;
    Map<Integer,Integer> valueFreq;
    int maxFreq;

    public FreqStack() {
        frequencyLevels = new HashMap<>();
        valueFreq = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int currValFreq = valueFreq.getOrDefault(val,0)+1;
        valueFreq.put(val,currValFreq);

        frequencyLevels.computeIfAbsent(currValFreq , k -> new Stack<Integer>()).push(val);

        if( maxFreq < currValFreq ) maxFreq = currValFreq;
    }
    
    public int pop() {
        Stack<Integer> levelFreqStack = frequencyLevels.get(maxFreq);
        int mostFreqElement = levelFreqStack.pop();
        valueFreq.put(mostFreqElement,maxFreq-1);

        if( levelFreqStack.isEmpty() ){
            maxFreq--;
        }

        return mostFreqElement;
    }
}