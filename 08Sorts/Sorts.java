import java.util.Arrays;
public class Sorts{

    public static String name(){
        return "09.Li.Johnson";
    }

    public static void SelectionSort(int[] data){
        for (int i = 0; i < data.length; i++){
            int min = i;
            for (int ii = i + 1; ii < data.length; ii++){
                if (data[ii] < data[min]){
                    min = ii;
                }
            }
            int temp = data[min];
            data[min] = data[i];
            data[i] = temp;
        }
    }

    public static void InsertionSort(int[] data){
        for (int i = 1; i < data.length; i++){
            for (int ii = i; ii > 0; ii--){
                if (data[ii] < data[ii - 1]){
                    int temp = data[ii - 1];
                    data[ii - 1] = data[ii];
                    data[ii] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] intAry = new int[15];
        for(int i = 0 ; i < intAry.length; i++){
            intAry[i] = (int)(Math.random() * 100);
        }
        System.out.println(Arrays.toString(intAry));
        InsertionSort(intAry);
        System.out.println(Arrays.toString(intAry));
    }
}
