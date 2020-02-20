import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<String> fruits = new Stack<>(7);


    @BeforeEach
    void setUp() {
        try {
            fruits.push("apple");
            fruits.push("orange");
            fruits.push("banana");
            fruits.push("pear");
            fruits.push("plumb");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isEmpty() {
        Stack<String> stack = new Stack<String>(6);
        try {
            stack.push("ahoj");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(stack.isEmpty()); //test
        assertFalse(fruits.isEmpty()); //test

        Stack<String> stack2 = new Stack<>(0);
        assertTrue(stack2.isEmpty()); //test

        fruits.empty();
        assertTrue(fruits.isEmpty()); //test
    }

    @Test
    void isFull() {
        Stack<String> stack = new Stack<>(4);
        try {
            stack.push("hi");
            stack.push("hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertFalse(stack.isFull()); //test

        Stack<String> stac2 = new Stack<>(3);
        try {
            stac2.push("tomas");
            stac2.push("jano");
            stac2.push("lukas");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(stac2.isFull()); //test

        assertFalse(fruits.isFull()); //test

    }

    @Test
    void push() {
        try {
            fruits.push("kiwi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(6,fruits.getSize()); //test

        try {
            fruits.push("mango");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(7,fruits.getSize()); //test
        assertEquals("mango", fruits.top()); //test

        assertNull(null, fruits.top()); //test
    }

    @Test
    void pop() {
        try {
            fruits.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(4,fruits.getSize()); //test
        assertEquals("pear", fruits.top()); //test
        assertFalse(fruits.isFull()); //test

    }

    @Test
    void top() {
        try {
            fruits.push("rasberry");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("rasberry", fruits.top()); //test

        fruits.empty();
        assertNull(fruits.top()); //test
        try {
            fruits.push("mango");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("mango", fruits.top()); //test
    }

    @Test
    void topAndPop() {
        try {
            assertEquals("plumb", fruits.topAndPop()); //test
            fruits.push("blueberry");
            assertEquals("blueberry", fruits.topAndPop()); //test
            assertEquals("pear", fruits.top()); //test
            fruits.empty();
//            assertNull(fruits.topAndPop()); //test prejde ale vyhodi excep.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void getSize() {
        assertEquals(5, fruits.getSize()); //test
        try {
            fruits.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(4,fruits.getSize()); //test
        fruits.empty();
        assertEquals(0,fruits.getSize()); //test
        try {
            fruits.push(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(0,fruits.getSize()); //test
    }

    @Test
    void getCapacity() {
        assertEquals(7, fruits.getCapacity()); //test
        fruits.empty();
        assertEquals(7,fruits.getCapacity()); //test
        try {
            fruits.push("banana");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(7, fruits.getCapacity()); //test
    }

    @Test
    void empty() {
        fruits.empty();
        assertEquals(0, fruits.getSize()); //test
        try {
            fruits.push(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(0,fruits.getSize()); //test


    }
}