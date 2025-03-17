package easyQuestions;

import java.util.Stack;

public class ValidParentheses {
    /**
     Given a string s containing just the character '(', ')' '{', '}', '[' and ']',
     determine if the input string is valis.
     An input string is valid if:
     1. open brackets must be closed by the same type of brackets.
     2. open brackets must be closed in the correct order.
     3. Every close bracket has a corresponding open bracket of the same type.
     */


        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    // Push open brackets onto the stack
                    stack.push(c);
                } else {
                    // If the stack is empty or the top element doesn't match the closing bracket, return false
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                            (c == '}' && top != '{') ||
                            (c == ']' && top != '[')) {
                        return false;
                    }
                }
            }

            // If the stack is empty, all brackets were matched correctly
            return stack.isEmpty();
        }


    }


