public class LinkedListDeque<T>{
    private class LinkedList{
        public LinkedList front; 
        public T node;
        public LinkedList last;
        
       

        public LinkedList(T thing, LinkedList f, LinkedList l){
            node=thing;
            front=f;
            last=l;
        }

    }
    private LinkedList sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel=new LinkedList(null,null,null);
        size=0;
    }

    public void addFirst(T item){
        if(size==0){
            sentinel.front=new LinkedList(item,sentinel,sentinel);
            sentinel.last=sentinel.front;
        }
        else{
            sentinel.front=new LinkedList(item,sentinel,sentinel.front);
            
        }
        size+=1;
    }
    public void addLast(T item){
        if(size==0){
            sentinel.last=new LinkedList(item,sentinel,sentinel);
            sentinel.front=sentinel.last;
        }
        else{
            sentinel.last=new LinkedList(item,sentinel.last,sentinel);
        }
        size+=1;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        
        if(size==0){
            System.out.println("Empty");
            return;
        }
        else{
            LinkedList p=sentinel.front;
            while(p!=sentinel){
                System.out.print(p.front.node+" ");
                p=p.last;
            }
            System.out.println();
            return;
        }
    }
    public T removeFirst(){
        if(size==0){
            return null;
        }
        else{
            T temp=sentinel.front.node;
            sentinel.front=sentinel.front.last;
            size-=1;
            return temp;
        }
    }

    public T removeLast(){
        if(size==0){
            return null;
        }
        else{
            T temp=sentinel.last.node;
            sentinel.last=sentinel.last.front;
            size-=1;
            return temp;
        }
    }
    public T get(int index){
        if(index>=size){
            return null;
        }
        else{
            LinkedList p=sentinel.front;
            while(index>0){
                p=p.last;
                index-=1;
            }
            return p.node;
        }
    }
    public T getRecursive(int index){
        if(index>=size){
            return null;
        }
        else{
            LinkedList p=sentinel.front;
            return getRecursiveHelper(index,p);
        }
    }
    private T getRecursiveHelper(int index,LinkedList p){
        if(index==0){
            return p.node;
        }
        else{
            return getRecursiveHelper(index-1,p.last);
        }
    }

}