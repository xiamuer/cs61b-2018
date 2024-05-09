package synthesizer;

import java.util.Iterator;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{
    //要么宣称抽象的，要么要实现接口的所有方法
    //但是抽象不能被实例化要是不能new
    protected int fillCount;
    protected int capacity;
    @Override
    public int capacity(){
        return capacity;
    }
    @Override
    public int fillCount(){
        return fillCount;
    }



}
