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

    public static String toZip(String barcode){
        String code = barcode.substring(1,barcode.length() - 1);
        String zip = "";
        String currentNum = "";
        for (int i = 0; i < barcode.length() - 5; i++){
            if (currentNum.length() == 5){
                for (int ii = 0; ii < codeConversionCode.length; ii++){
                    if(codeConversionCode[ii].equals(currentNum)){
                        zip += Integer.toString(ii);
                    }
                }
                currentNum = "";
            }
            try{
                currentNum += code.substring(i, i+1);
            }catch(StringIndexOutOfBoundsException e){
            }
        }
        return zip;
    }

    /*public String toString(){
        return zip;
    }*/

    public static void main(String[] args) {
        Barcode code = new Barcode("11214");
        System.out.println(toCode("11214"));
        System.out.println(toZip("|:::||:::||::|:|:::||:|::||:|::|"));
        System.out.println(getChecksum("11214")); //9
        System.out.println(toCode("72801"));
        System.out.println(toZip("||:::|::|:||::|:||::::::|||::|:|"));
        System.out.println(getChecksum("72801")); //8
    }
}
