package stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTest {

    Expression expression;

    @BeforeEach
    void setUp() {
        expression = new Expression();
    }

    @Test
    void isBalanced() {
        assertTrue(expression.isBalanced("[]"));
        assertTrue(expression.isBalanced("(1+2+3)"));
        assertTrue(expression.isBalanced("{444}"));
        assertTrue(expression.isBalanced("<>"));

        assertFalse(expression.isBalanced("{"));
        assertFalse(expression.isBalanced("(()]"));
        assertFalse(expression.isBalanced(")("));
        assertFalse(expression.isBalanced(")("));
        assertFalse(expression.isBalanced("{>"));
    }
}