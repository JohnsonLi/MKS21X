class ReverseCharSequence implements CharSequence{

    private String str;

    public ReverseCharSequence(String str){
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--){
            reversed += str.charAt(i);
        }
        this.str = reversed;
    }

    public char charAt(int index){
        return str.charAt(index);
    }

    public int length(){
        return str.length();
    }

    public CharSequence subSequence(int start, int end){
        String reversedStr = str.substring(start, end);
        String fixed = "";
        for (int i = reversedStr.length() - 1; i >= 0; i--){
            fixed += reversedStr.charAt(i);
        }
        return new ReverseCharSequence(fixed);
    }

    public String toString(){
        return str;
    }

}
