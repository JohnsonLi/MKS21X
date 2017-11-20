public class OrderedSuperArray extends SuperArray{

    /*constructor initializes an empty List*/
    public OrderedSuperArray(){
        super();
    }

    public OrderedSuperArray(String[] arr){
        super();
        for (int i = 0; i < arr.length; i++){
            add(arr[i]);
        }
    }

    /*call the proper add.*/
    public void add(int index, String value){
        add(value);
    }

    /*Write this method and any
        appropriate helper methods.*/
    public boolean add(String value){
        //add to the correct spot.
        //you may still use super.add(index,value)
        super.add(findIndexBinary(value), value);
        return true;
    }

    private int findIndex(String value){
        for (int i = size() - 1; i >= 0; i--){
           if (value.compareTo(get(i)) > 0){
              return i + 1;
           }
        }
        return 0;
    }

    private int findIndexBinary(String value){
        if (size() == 0){
            return 0;
        }

        int start = 0;
        int end = size();
        while (start != end){
            if (value.compareTo(get((start + end) / 2)) >= 0){
                start = (start + end) / 2 + 1;
            } else {
                end = (start + end) / 2;
            }
        }
        return start;
    }

    public int indexOfBinary(String value){
        int firstSoFar = -1;
        int start = 0;
        int end = size();

        if (get(0).equals(value)){
            return 0;
        }

        while (start <= end){
            if (get((start + end) / 2).equals(value)){
                firstSoFar = (start + end) / 2;;
                end = (start + end) / 2 - 1;
            }

            if (value.compareTo(get((start + end) / 2)) <= 0){
                end = (start + end) / 2 - 1;
            } else {
                start = (start + end) / 2 + 1;
            }
        }

        return firstSoFar;
    }

    public int lastIndexOfBinary(String value){
        int lastSoFar = -1;
        int start = 0;
        int end = size();

        if (get(size() - 1).equals(value)){
            return size() - 1;
        }

        while (start <= end){
            if (get((start + end) /2).equals(value)){
                lastSoFar = (start + end) / 2;
                start = (start + end) / 2;
            }

            if (value.compareTo(get((start + end) / 2)) <= 0){
                end = (start + end) / 2 - 1;
            } else {
                start = (start + end) / 2 + 1;
            }
        }
        return lastSoFar;
    }


}
