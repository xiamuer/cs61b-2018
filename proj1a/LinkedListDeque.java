public class LinkedListDeque <Item>{
    private class ItemNode{
        public ItemNode pre;   //指针域(前)
        public Item item;      //数据域
        public ItemNode next;  //指针域(后)
        //节点初始构造时的赋值
         private ItemNode(ItemNode p,Item i,ItemNode n){
            pre=p;
            item=i;
            next=n;
            //this(null,null,null)  Recursive constructor invocation 递归函数调用
        }
    }
    /*私有变量，辅助作用*/
    private int size;
    private ItemNode  sentFront;
    private ItemNode  sentBack;
    //创建新的空队列
    public LinkedListDeque(){
        sentFront=null;
        sentBack=null;
        size=0;
    }
    //如果创建队列的时候传值了
    public LinkedListDeque(Item x){
        ItemNode NewNode=new ItemNode(null,x,null);
        size=1;
        sentFront=NewNode;
        sentBack=NewNode;
    }
    public void addFirst(Item x){
        ItemNode NewNode=new ItemNode(null,x,null);
        if(size==0){
            sentFront=NewNode;
            sentBack=NewNode;
        }
        else{
            NewNode.next=sentFront;
            sentFront.pre=NewNode;
            sentFront=NewNode;
        }
        size++;
    }
    public void addLast(Item x){
        ItemNode NewNode=new ItemNode(null,x,null);
        if(size==0){
            sentFront=sentBack=NewNode;
        }
        else{
            sentBack.next=NewNode;
            NewNode.pre=sentBack;
            sentBack=NewNode;
        }
        size++;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        ItemNode L=sentFront;
        while(L!=null){
            System.out.print(L.item+" ");
            L=L.next;
        }
        System.out.println();
    }
    public Item removeFirst(){
        if(size==0) return null;
        Item x=sentFront.item;
        if(size==1){
            sentFront=sentBack=null;
        }
        else {
            sentFront=sentFront.next;
        }
        size--;
        return x;
    }
    public Item removeLast(){
        if(size==0) return null;
        Item x=sentBack.item;
        if(size==1){
            sentFront=sentBack=null;
        }
        else{
            sentBack=sentBack.pre;
        }
        size--;
        return x;
    }
    public Item get(int index){
        if(index<0||index>=size) return null;
        ItemNode L=sentFront;
        for(int i=0;i<index;i++)
            L=L.next;
        return L.item;
    }
    public Item getRecursive(int index){
        return get(index);
    }

}
