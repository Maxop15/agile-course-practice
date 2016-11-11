import main.java.Deque;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WhenAddDeleteElementToDeque {
    private Deque newDeque;

    @Before
    public void setUp() throws  Exception {
        newDeque = new Deque();
    }

    @Test
    public void getSizeEmptyDeque() {
        Deque emptyDeque = new Deque();
        int sizeDeque = newDeque.getCurrentSize();
        assertEquals(0, sizeDeque);
    }

    @Test
    public void pushHeadIntElement() {
        newDeque.pushHeadElement(5);
        assertEquals(1, newDeque.getCurrentSize());
    }

    @Test
    public void checkSizeAfterClear() {
        newDeque.pushHeadElement(5);
        newDeque.clear();
        assertEquals(0, newDeque.getCurrentSize());
    }

    @Test
    public void popHeadIntElement() {
        newDeque.pushHeadElement(5);
        int element =  newDeque.popHeadElement();
        assertEquals(element, 5);
    }

    @Test
    public void pushTailIntElement() {
        newDeque.pushTailElement(5);
        assertEquals(1, newDeque.getCurrentSize());
    }

    @Test
    public void popTailIntElement() {
        newDeque.pushTailElement(5);
        int element = newDeque.popTailElement();
        assertEquals(5, element);
    }

    @Test
    public void checkIsEmptyMethod() {
        newDeque.pushTailElement(5);
        assertEquals(false, newDeque.isEmpty());
        newDeque.popHeadElement();
        assertEquals(true, newDeque.isEmpty());
    }

    @Test
    public void pushToHeadPopFromHead() {
        for (int i = 0; i < 5; i++) {
            newDeque.pushHeadElement(i);
        }
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = result * 10 + newDeque.popHeadElement();
        }
        assertEquals(43210, result);
    }

    @Test
    public void pushToTailPopFromTail() {
        for (int i = 0; i < 5; i++) {
            newDeque.pushTailElement(i);
        }
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = result * 10 + newDeque.popTailElement();
        }
        assertEquals(43210, result);
    }

    @Test
    public void pushElementsMoreDequeSize() {
        for (int i = 0; i < 101; i++) {
            newDeque.pushTailElement(i);
        }
        assertEquals(101, newDeque.getCurrentSize());
    }

    @Test
    public void pushToHeadPopFromTail() {
        for (int i = 0; i < 5; i++) {
            newDeque.pushHeadElement(i);
        }
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = result * 10 + newDeque.popTailElement();
        }
        assertEquals(1234, result);
    }

    @Test
    public void pushToTailPopFromHead() {
        for (int i = 0; i < 5; i++) {
            newDeque.pushTailElement(i);
        }
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = result * 10 + newDeque.popHeadElement();
        }
        assertEquals(1234, result);
    }

}
