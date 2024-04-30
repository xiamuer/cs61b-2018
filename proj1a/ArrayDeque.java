import java.awt.*;

public class ArrayDeque <T>{
    private T[] items;
    private int size;
    private int Front;
    private int Back;
    public ArrayDeque() {
        items=(T[]) new Object[8];
        size=0;
        Front=items.length-1;
        Back=0;
    }
    public void rerize(int capacity){
        T[] a=(T[]) new Object[capacity];
        if(Back-1<0) Back=items.length-1;
        else Back=(Back-1)%items.length;
        for(int i=0;i<=Back;i++){
            a[i]=items[i];
        }
        int lenold=items.length;
        int lennew=a.length-1;
        Front=(Front+1)%items.length;
        for(int i=lenold-1;i>=Front;i--){
            a[lennew]=items[i];
            lennew--;
        }
        Back=(Back+1)%a.length;
        Front=lennew;

        items=a;
    }
    public void addFirst(T x){
        if(size==items.length){
            rerize((int)(Math.round(size*2)));
        }
        items[Front]=x;
        if((Front-1)<0){
            Front=items.length-1;
        }
        else {
            Front=(Front-1)%items.length;
        }
        size+=1;
    }
    public void addLast(T x){
        if(size==items.length){
            rerize((int)(Math.round(size*2)));
        }
        items[Back]=x;
        Back=(Back+1)%(items.length);
        size++;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        int first=(Front+1)%items.length;
        int Last=Back;
        if(Last-1<0) Last=items.length-1;
            else Last=(Last-1)%items.length;
        for(int i=0;i<size;i++){
            System.out.print(items[first]+" ");
            first=(first+1)%(items.length);
        }
        System.out.println();
    }
    public T removeFirst(){
        if(size==0){
            return null;
        }
        Front=(Front+1)%items.length;
        T x=items[Front];
        size--;
        items[Front]=null;
        return x;
    }
    public T removeLast(){
        if(size==0){
            return null;
        }
        if((Back-1)<0){
            Back=items.length-1;
        }
        else {
            Back=(Back-1)%items.length;
        }
        T x=items[Back];
        size--;
        items[Back]=null;
        return x;
    }
    public T get(int index){
        if(index<0||index>=items.length) return null;
        int fist=(Front+1)%items.length;
        for(int i=0;i<index;i++){
            fist=(fist+1)%items.length;
        }
        return items[fist];
    }
    public T getRecursive(int index){
        return get(index);
    }




}
