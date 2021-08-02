package stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }


    @Test
    void testPush() {
        stack.push(10);
        assertEquals(10, stack.pop());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

    }

    @Test
    void testPop() {
    }

    @Test
    void testPeek() {
        stack.push(10);
        stack.peek();
        assertFalse(stack.isEmpty());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        assertFalse(stack.isEmpty());
        while (!stack.isEmpty()) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }
}