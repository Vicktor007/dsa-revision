package Toknows;

import java.util.Queue;
import java.util.Stack;

public class ReversingTheFirstKElementsOfAQueue {
    /**
     Reversing the first K elements of a Queue

     Given an integer k and a queue of integers, The task is to reverse the order of the first k elements of the queue, leaving the other elements in the same relative order.
     Only following standard operations are allowed on queue.
     • enqueue(x): Add an item x to rear of queue
     • dequeue(): Remove an item from front of queue
     • size(): Returns number of elements in queue.
     • front(): Finds front item.
     */

    public static void reverseKElements(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid input");
        }

        Stack<Integer> stack = new Stack<>();

        // Step 1: Push the first k elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Enqueue elements from stack back into the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Step 3: Move the remaining elements (n-k) to the back of the queue
        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.offer(queue.poll());
        }
    }
}
