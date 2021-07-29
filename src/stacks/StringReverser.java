package stacks;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException("String cannot be empty");
        }

        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        StringBuffer revStr = new StringBuffer();
        while (!stack.isEmpty()) {
            revStr.append(stack.pop());
        }

        return revStr.toString();
    }
}
