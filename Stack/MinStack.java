import java.util.Stack;

public class MinStack {
    private int min;
    private Stack<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    public void push(int val){
        if (stack.isEmpty()){
             min = val;
             stack.push(val);
        } else if (val <  min) {
             stack.push(2 * val -  min);
             min = val;
        } else  stack.push(val);
    }

    public void pop(){
        if(stack.isEmpty()) return;
        else if (stack.peek() <  min) {
             min = 2 *  min -  stack.peek();
             stack.pop();
        } else stack.pop();

        if (stack.isEmpty()) {
            min = Integer.MAX_VALUE;  // reset when empty
        }
    }

    public int top(){
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty");
        else if (stack.peek() <  min) {
            return  min;
        }
        return stack.peek();
    }

    public int getMin(){
        return  min;
    }

    public static void main(String[] args){
        MinStack ms = new MinStack();

        // Test 1: basic push/getMin
        System.out.println("Test 1: basic push/getMin [push 5, push 2, push 8]");
        ms.push(5);
        System.out.println("min=5? " + ms.getMin()); // 5
        ms.push(2);
        System.out.println("min=2? " + ms.getMin()); // 2
        ms.push(8);
        System.out.println("top=8? " + ms.top());    // 8
        System.out.println("min=2? " + ms.getMin()); // 2

        // Test 2: pop normal value
        System.out.println("Test 2: pop normal value [pop]");
        ms.pop(); // pop 8
        System.out.println("top=2? " + ms.top());    // 2
        System.out.println("min=2? " + ms.getMin()); // 2

        // Test 3: pop encoded (removes current min)
        System.out.println("Test 3: pop encoded (removes current min) [pop]");
        ms.pop(); // pop 2 (encoded case)
        System.out.println("top=5? " + ms.top());    // 5
        System.out.println("min=5? " + ms.getMin()); // 5

        // Test 4: negatives
        System.out.println("Test 4: negatives [push -3, push -10, pop]");
        ms.push(-3);
        System.out.println("min=-3? " + ms.getMin()); // -3
        ms.push(-10);
        System.out.println("min=-10? " + ms.getMin()); // -10
        ms.pop();
        System.out.println("min=-3? " + ms.getMin()); // -3

        // Test 5: pop to empty then verify exceptions
        System.out.println("Test 5: pop to empty then verify exceptions [pop, pop]");
        ms.pop(); // pop -3
        ms.pop(); // pop 5 -> now empty

        try {
            ms.getMin();
        } catch (Exception e) {
            System.out.println("getMin on empty -> OK error: " + e.getMessage());
        }

        try {
            ms.top();
        } catch (Exception e) {
            System.out.println("top on empty -> OK error: " + e.getMessage());
        }
    }

}

// problem description: https://leetcode.com/problems/min-stack/description/
