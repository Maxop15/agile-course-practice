import Deque.java.Deque;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WhenAddDeleteElementToDeque {
    private Deque<Integer>  IntDeque;
    private Deque<String> StrDeque;

    @Before
    public void setUp() throws  Exception {
        IntDeque = new Deque<Integer>();
        StrDeque = new Deque<String>();
    }

    @Test
    public void GetSizeEmptyDeque() {
        Deque<Integer> EmptyDeque = new Deque<Integer>();
        int sizeDeque = Deque.GetCurrentSize();
        assertEquals(0,sizeDeque);
    }

    @Test
    public void PushHeadIntElement() {
        IntDeque.PushHeadElement(5);
        assertEquals(1, IntDeque.GetCurrentSize());
    }

    @Test
    public void CheckSizeAfterClear() {
        IntDeque.PushHeadElement(5);
        IntDeque.Clear();
        assertEquals(0, IntDeque.GetCurrentSize());
    }

    @Test
    public void PopHeadIntElement() {
        IntDeque.PushHeadElement(5);
        int Element =  IntDeque.PopHeadElement();
        assertEquals(Element, 5);
    }

    @Test
    public void PushTailIntElement() {
        IntDeque.PushTailElement(5);
        assertEquals(1, IntDeque.GetCurrentSize());
    }

    @Test
    public void PopTailIntElement() {
        IntDeque.PushTailElement(5);
        int Element = IntDeque.PopTailElement();
        assertEquals(5,Element);
    }

    @Test
    public void CheckIsEmptyMethod() {
        IntDeque.PushTailElement(5);
        assertEquals(false, IntDeque.IsEmpty());
        IntDeque.PopHeadElement();
        assertEquals(true, IntDeque.IsEmpty());
    }

    @Test
    public void PushAndPopString() {
        StrDeque.PushHeadElement("Hello, world!");
        assertEquals("Hello, world!", StrDeque.PopHeadElement());
    }

    @Test
    public void FewPushPopFromHead() {
        for (int i = 0; i < 5; i++) {
            IntDeque.PushHeadElement(i);
        }
        int result = 0;
        for (int i = 0; i < 5; i++){
            result = result * 10 + IntDeque.PopHeadElement();
        }
        assertEquals(43210, result);
    }

    @Test
    public void FewPushPopFromTail() {
        for (int i = 0; i < 5; i++) {
            IntDeque.PushTailElement(i);
        }
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = result * 10 + IntDeque.PopTailElement();
        }
        assertEquals(43210, result);
    }

    @Test
    public void PushElementsMoreDequeSize() {
        for (int i = 0; i < 101; i++) {
            IntDeque.PushTailElement(i);
        }
        assertEquals(101, IntDeque.GetCurrentSize());
    }

    @Test
    public void PushToHead_PopFromTail() {
        for (int i = 0; i < 5; i++) {
            IntDeque.PushHeadElement(i);
        }
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = result * 10 + IntDeque.PopTailElement();
        }
        assertEquals(1234, result);
    }

    @Test
    public void PushToTail_PopFromHead() {
        for (int i = 0; i < 5; i++) {
            IntDeque.PushTailElement(i);
        }
        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = result * 10 + IntDeque.PopHeadElement();
        }
        assertEquals(1234, result);
    }

}
