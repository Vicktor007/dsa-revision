package easyQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementingStackUsingQueues {
    /**
     Implement a last in first out stack using only two queues.
     The implemented stack should support all the functions of a normal stack
     (push, top, pop and empty).
     Implement the MyStack class:
     . void push(int x ) pushes element x to the top of the stack.
     . int pop() removes the element on the top of the stack and returns it.
     . int top() returns the element on the top of the stack.
     . boolean empty() returns true if the stack is empty, false otherwise.

     Notes:
     .You must use only standard operations of a queue, which means that only
     push o back, peek/pop from front, size and is empty operations are valid.
     . depending on your language, the queue may not be supported natively. You may simulate
     a queue using a list or a deque(double-ended queue) as long as you use only a queue's
     standard operations.
     */



    class MyStack {

        private Queue<Integer> queue1; // Primary queue
        private Queue<Integer> queue2; // Helper queue

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        // Push element x to the top of the stack.
        public void push(int x) {
            queue2.offer(x); // Add to the helper queue
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll()); // Move elements from primary to helper queue
            }
            // Swap the queues
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        // Removes the element on the top of the stack and returns it.
        public int pop() {
            if (queue1.isEmpty()) throw new RuntimeException("Stack is empty");
            return queue1.poll();
        }

        // Returns the element on the top of the stack.
        public int top() {
            if (queue1.isEmpty()) throw new RuntimeException("Stack is empty");
            return queue1.peek();
        }

        // Returns true if the stack is empty, false otherwise.
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

}
