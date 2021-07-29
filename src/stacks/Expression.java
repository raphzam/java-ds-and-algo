package stacks;

import java.util.Stack;

public class Expression {
    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch)) {
                stack.push(ch);
            }

            if (isRightBracket(ch)) {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!bracketsMatch(ch, top)) return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean bracketsMatch(char right, char left) {
        return (right == ')' && left == '(') ||
                (right == '>' && left == '<') ||
                (right == ']' && left == '[') ||
                (right == '}' && left == '{');
    }

    private boolean isRightBracket(char ch) {
        return ch == ')' || ch == '>' || ch == ']' || ch == '}';
    }

    private boolean isLeftBracket(char ch) {
        return ch == '(' || ch == '<' || ch == '[' || ch == '{';
    }
}
