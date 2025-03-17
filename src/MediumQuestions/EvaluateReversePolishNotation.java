package MediumQuestions;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    /**
     You are given an array of strings tokens that represents
      an arithmetic expression in a reverse polish notation.
     Evaluate the expression. Return an integer that represents the value of the expression.

     Note that:
     . The valid operators are '+', '-', '*' and '/'.
     . Each operand may be an integer or another expression.
     . The division between two integers always truncates toward zero.
     . There will not be any division by zero.
     . The input represents a valid arithmetic expression in a reverse polish notation.
     . The answer and all the intermediate calculations can be represented in a 32=bit integer.
     */
// time: o(n), space: o(n)
    public int reversePolishNotation(String[] tokens){
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens){
            switch (token){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a-b);
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    int divisor=stack.pop();
                    int dividend= stack.pop();
                    stack.push(dividend/divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return  stack.pop();
    }
}
