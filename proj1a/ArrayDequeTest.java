import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void testaddsizeempty() {
        ArrayDeque<String> dq = new ArrayDeque<String>();
        assertEquals(true, dq.isEmpty());

        dq.addFirst("first");
        assertEquals(1, dq.size());

        dq.addLast("last");
        assertEquals(2, dq.size());

        dq.printDeque();

        String first = dq.removeFirst();
        assertEquals("first", first);

        String last = dq.removeLast();
        assertEquals("last", last);

        assertEquals(0, dq.size());
    }
    //@Test
//    public void create() {
//        ArrayDeque<Integer> dq = new ArrayDeque<>();
//        for (int x : array) {
//            dq.addLast(x);
//        }
//    }
    @Test
    public  void testgrowshrink() {
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        for (int i = 0; i < 16; i++) {
            dq.addLast(i);
        }
        for (int i = -16; i < 0; i++) {
            dq.addFirst(i);
        }
//        for (int i = -1; i <= 16; i++) {
//
//            assertEquals(i, dq.get(i));
//        }
        for (int i = 0; i < 30; i++) {
            dq.removeFirst();
        }
        assertEquals(2, dq.size());
        dq.printDeque();
    }
    @Test
    public void PrintTest(){
        ArrayDeque<Integer> dp=new ArrayDeque<Integer>();
        for(int i=0;i<9;i++)
            dp.addLast(i);
        dp.printDeque();
    }

}