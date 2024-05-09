package synthesizer;
import java.util.Iterator;
public interface BoundedQueue<T> extends Iterable<T>{   //接口，你写了什么都要去实现
    int capacity();
    int fillCount();
    void enqueue(T x);
    T dequeue();
    T peek();
    Iterator<T> iterator();//override就代表你有没有实现
    default boolean isEmpty(){
        return fillCount()==0;
    }

    default boolean isFull(){
        return fillCount()==capacity();
    }

}
