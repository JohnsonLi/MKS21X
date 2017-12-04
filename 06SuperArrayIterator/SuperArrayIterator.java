import java.util.Iterator;

public class SuperArrayIterator implements Iterable<String>{
    private int index = 0;
    private SuperArray arr;

    public SuperArrayIterator(SuperArray arr){
        this.arr = arr; 
    }

    public boolean hasNext(){
        return current < arr.size();
    }

    public String next(){
        if(hasNext()){
            return arr.get(current++);
        }
        throw new NoSuchElementException();
    }

    public void remove(){
        throw new UnsupportedOperationException();
}