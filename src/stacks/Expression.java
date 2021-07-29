package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');
    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');

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
        return rightBrackets.indexOf(right) == leftBrackets.indexOf(left);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }
}
