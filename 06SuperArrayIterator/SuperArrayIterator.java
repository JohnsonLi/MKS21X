import java.util.*;

public class SuperArrayIterator implements Iterator<String>{
    private int index = 0;
    private SuperArray arr;

    public SuperArrayIterator(SuperArray arr){
        this.arr = arr; 
    }

    public boolean hasNext(){
        return index < arr.size();
    }

    public String next(){
        if(hasNext()){
            return arr.get(index++);
        }
        throw new NoSuchElementException();
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }   
}