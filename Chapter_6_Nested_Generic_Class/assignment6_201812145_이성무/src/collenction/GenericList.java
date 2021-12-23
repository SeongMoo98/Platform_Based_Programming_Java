package collenction;

public class GenericList<T>{
    private static final int DEFAULT_SIZE=10;
    private static int index=0;
    private Object[] data;
    private int size;

    public GenericList(){
        size=DEFAULT_SIZE;
        data =new Object[10];
        for(int i=0; i<10; i++)
        {
            data[i]=null;
        }
    }
    public GenericList(int size){
        this.size=size;
        data =new Object[this.size];
        for(int i=0; i<this.size; i++) {
            data[i]=null;
        }
    }

    private void newSize(){
        int newSize=2*size;
        Object[] copy=new Object[newSize];

        for(int i=0; i<size; i++){
            copy[i]=data[i];
        }

        data=new Object[newSize];
        for(int i=0; i<newSize;i++){
            data[i]=copy[i];
        }
    }

    public void add(T object) {
        data[index] = object;
        index++;
        if(size==index){
            newSize();
        }
    }

    public void clear(){
        for(int i=0; i<size; i++){
            data[i]=null;
        }
        index=0;
        size=0;
    }
    public T get(int i){
        return (T) data[i];
    }
    public int size(){
        return this.size;
    }
}
