import java.util.Arrays;
public class Sorts{

    public static String name(){
        return "09.Li.Johnson";
    }

    public static boolean isSorted(int[]ary){
        for(int i = 0; i < ary.length - 1 ; i++){
            if(ary[i] > ary[i+1]){
                return false;
            }
        }
        return true;
    }

    private static void swap(int[]ary,int a, int b){
        int c = ary[a];
        ary[a] = ary[b];
        ary[b] = c;
    }

    public static void bogoSort(int[] ary){
        while(!isSorted(ary)){
            for(int i = 0 ; i < ary.length; i++){
                int temp = ary[i];
                int newSpot = (int)(Math.random()*ary.length);
                ary[i] = ary[newSpot];
                ary[newSpot] = temp;
            }
        }
    }

    public static void selectionSort(int[] data){
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

    public static void insertionSort(int[] data){
        for (int i = 1; i < data.length; i++){
            for (int ii = i; ii > 0; ii--){
                if (data[ii] < data[ii - 1]){
                    int temp = data[ii - 1];
                    data[ii - 1] = data[ii];
                    data[ii] = temp ;
                }
            }
        }
    }

    public static void bubbleSort(int[] data){
       int aryLen = data.length;
       for (int i = 0; i < aryLen; i++){
           for (int ii = 0; ii < aryLen - i - 1; ii++){
               if (data[ii] > data[ii + 1]){
                   swap(data, ii, ii + 1);
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
       bubbleSort(intAry);
       System.out.println(Arrays.toString(intAry));
   }
}
