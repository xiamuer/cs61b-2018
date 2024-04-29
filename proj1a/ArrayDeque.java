public class ArrayDeque <Item>{
    private Item[] items;
    private int size;
    private int Front;
    private int Back;
    public ArrayDeque(){
        items=(Item[]) new Object[8];
        size=0;
        Front=0;
        Back=items.length-1;
    }
    public void rerize(int capacity){
        Item[] a=(Item[]) new Object[capacity];
        for(int i=0;i<Back;i++){
            a[i]=items[i];
        }
        int lenold=items.length;
        int lennew=a.length;
        for(int i=lenold-1;i>Front;i++){
            a[lennew-1]=items[i];
            lennew--;
        }
        Front=lennew;
        items=a;
    }
    public void addFirst(Item x){
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
    public void addLast(Item x){
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
        while (first!=Back){
            System.out.print(items[first]);
            first=(first+1)/(items.length);
        }
        System.out.println();
    }
    public Item removeFirst(){
        if(size==0){
            return null;
        }
        Front=(Front+1)%items.length;
        Item x=items[Front];
        size--;
        items[Front]=null;
        return x;
    }
    public Item removeLast(){
        if(size==0){
            return null;
        }
        if((Back-1)<0){
            Back=items.length-1;
        }
        else {
            Back=(Back-1)%items.length;
        }
        Item x=items[Back];
        size--;
        items[Back]=null;
        return x;
    }
    public Item get(int index){
        if(index<0||index>=items.length) return null;
        int fist=(Front+1)%items.length;
        for(int i=0;i<index;i++){
            fist=(fist+1)%items.length;
        }
        return items[fist];
    }




}
