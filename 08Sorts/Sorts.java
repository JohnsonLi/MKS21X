public class Sorts{

    public static String name(){
        return "01.Li.Johnson";
    }

    public static void SelectionSort(int[] data){
        for (int i = 0; i < data.length; i++){
            int min = i;
            for (int ii = i + 1; ii < data.length; ii++){
                if (data[ii] < data[i]){
                    min = ii;
                }
            }
            int temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
    }

    /*public static void InsertionSort(int [] data){

    }*/
}
