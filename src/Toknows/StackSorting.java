package Toknows;

import java.util.Stack;

public class StackSorting {
//    Given a stack of integers, sort them in ascending ofr descending order

    public Stack<Integer> stackSorting(Stack<Integer> array){
        Stack<Integer> stack = new Stack<>();
        while (!array.isEmpty() ){
            int currentNumber = array.pop();
            while (!stack.isEmpty() && stack.peek() > currentNumber){
                array.push(stack.pop());
            }
            stack.push(currentNumber);
        }
        return stack;

    }
}
