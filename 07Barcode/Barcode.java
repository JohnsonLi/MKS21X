import java.util.*;

public class Barcode /*implements Comparable<String>*/{
    private String zip;
    private static String[] codeConversionCode = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};

    public Barcode(String zip){
        if (zip.length() == 5){
            try{
                Integer.parseInt(zip);
            }catch(NumberFormatException e){
                throw new IllegalArgumentException();
            }
            this.zip = zip;
        }else if (zip.length() != 5){
            throw new IllegalArgumentException();
        }
    }

    public static String getChecksum(String zip){
        int sum = 0;
        for (int i = 0; i < zip.length(); i++){
            sum += Integer.parseInt(zip.substring(i, i + 1));
        }
        return (sum % 10) + "";
    }

    public static String toCode(String zip){
        String code = "|";
        for (int i = 0; i < zip.length(); i++){
            try{
                code += codeConversionCode[Integer.parseInt(zip.substring(i, i + 1))];
            }catch(IndexOutOfBoundsException e){
            }
        }
        return code + codeConversionCode[Integer.parseInt(getChecksum(zip))] + "|";
    }



    public String toString(){
        return zip;
    }

    public static void main(String[] args) {
        Barcode code = new Barcode("11214");
        System.out.println(toCode("11214"));
    }
}
