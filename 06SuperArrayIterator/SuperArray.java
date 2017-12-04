import java.util.*;
public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    public SuperArray(){
        data = new String[10];
    }

    public SuperArray(int size){
        data = new String[size];
    }

    public Iterator<String> iterator(){
        return new SuperArrayIterator(this);
    }

    public void clear(){
        data = new String[data.length];
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    /*public boolean oldAdd(String x){
        if (size() < data.length){
            data[size()] = x;
            size++;
            return true;
        }
        return false;
    }*/

    public boolean add(String element){
        resize();
        data[size()] = element;
        size++;
        return true;
    }


    public String toString(){
        String strArr = "[";
        for (int i = 0; i < size() - 1; i++){
            strArr += get(i) + ", ";
        }
        return  strArr += get(size() - 1) + "]";
    }


    public String get(int index){
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
     return data[index];
    }

    public String set(int index, String element){
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        String getsReturned = get(index);
        data[index] = element;
        return getsReturned;
    }

    private void resize(){
        if (size() == data.length - 1){
            String[] resizedArray = new String[(size * 2) + 1];
            for (int i = 0; i < size(); i++){
                resizedArray[i] = get(i);
            }
            data = resizedArray;
        }
    }

    public boolean contains(String element){
        boolean contain = false;
        for (int i = 0; i < size(); i++){
            if (get(i).equals(element)) {
                contain = true;
            }
        }
        return contain;
    }

    public int indexOf(String element){
        for (int i = 0; i < size(); i++){
            if (get(i).equals(element)){
                return i;
            }
        }
        return -1;
    }

    /*pubic int indexOfBinary(String element){
        int firstOcc = 0;
        int start = 0;
        int end = size();

        while (){

        }
    }*/

    public int lastIndexOf(String element){
        int highestSoFar = 0;
        for (int i = 0; i < size(); i++){
            if (get(i).equals(element)){
                highestSoFar = i;
            }
        }
        return highestSoFar;
    }

    public void add(int index, String element){
        if (index < 0 || index > size()){
            throw new IndexOutOfBoundsException("Invalid Index");
        }else {
            resize();
            for (int i = size() - 1; i > index -1; i--) {
                data[i + 1] = get(i);
            }
            set(index, element);
            size++;
            resize();
        }
    }

    public String remove(int index){
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        String toBeReturned = get(index);
        for (int i = index; i < size() - 1; i++){
            set(i, get(i + 1));
        }
        size--;
        return toBeReturned;
    }

    public boolean remove(String element){
        if (indexOf(element) != -1) {
            remove(indexOf(element));
            return true;
        }
        return false;
    }

}
