// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;


//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.

        rb=(T[])new Object[capacity];
        first=0;
        last=0;
        fillCount=0;
        this.capacity=capacity;//如果你不写this.capacity，会误以为是局部变量capacity所以要加this关键字
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.

        if(this.isFull()){
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last]=x;
        last=(last+1)%capacity;
        fillCount+=1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if(this.isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        T x=rb[first];
        rb[first]=null;
        first=(first+1)%capacity;
        fillCount--;
        return x;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if(this.isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    private class ArrayRingBufferIterator implements Iterator<T>{
        private int cur;
        private int num;
        public ArrayRingBufferIterator(){
            cur=first;
            num=0;
        }

        public boolean hasNext(){
            return num<fillCount;
        }

        public T next(){
            T x=rb[cur];
            cur=(cur+1)%capacity;
            num++;
            return x;
        }
    }
    @Override
    public Iterator<T> iterator(){
        return new ArrayRingBufferIterator();
    }
}
