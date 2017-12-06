public class Sorts{

    private static int[] intAry = {1,5,7,2,4,6,82,466,432235,233,4,57,8,2};


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

    public String toString(){
        String str = "[";
        for (int i = 0; i < intAry.length; i ++){
            str += intAry[i] + ", ";
        }
        return str + "]";
    }

    public static void main(String[] args) {
        Sorts test = new Sorts();
        System.out.println(test);
        test.SelectionSort(test.intAry);
        System.out.println(test);
    }
}
