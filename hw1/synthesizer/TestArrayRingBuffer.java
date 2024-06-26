package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        //arb.peek(); //return Ring buffer underflow
        arb.enqueue(1);
        arb.peek();
        arb.dequeue();
        for(int i=0;i<10;i++){
            arb.enqueue(i);
        }
        for(int i=0;i<10;i++){
            arb.dequeue();
        }
        for(int i=0;i<10;i++){
            arb.enqueue(i);
            //System.out.print(arb.isFull());
        }
        for(Object x:arb){
            System.out.print(x);
        }


    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
