package MediumQuestions;

import java.util.Stack;

public class MinStack {
    /**
     Design a stack that supports push, pop top, and retrieving the minimum
     element in constant time.

     Implement the minStack class:
     .MinStack() initializes the stack object.
     .void push(int val) pushes the element val onto the stack.
     .void pop() removes the element on top of the stack.
     .int top() gets the top element of the stack.
     .int getMin() retrieves the minimum element in th stack.
     You must implement a solution with 0(1) time complexity for each function.
     */

    class minStack{
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public void MinStack(){
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val){
            stack.push(val);

            // If the minStack is empty or val is less than or equal to the current minimum
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return; // Do nothing if the stack is empty
            }
            int removed = stack.pop();
            // If the value being removed is the current minimum, pop from minStack as well
            if (removed == minStack.peek()) {
                minStack.pop();
            }
        }

        public int top() {
            // Return the top value of the stack
            return stack.peek();
        }

        public int getMin() {
            // Return the top value of the minStack, which is the current minimum
            return minStack.peek();
        }
    }
}
