public class ReverseCharSequenceDriver {

    public static void main(String[] args) {
        ReverseCharSequence ooo = new ReverseCharSequence("ABCDEF");
        System.out.println(ooo.charAt(2));
        System.out.println(ooo.length());
        System.out.println(ooo.subSequence(0,4));
        System.out.println(ooo);
    }

}
