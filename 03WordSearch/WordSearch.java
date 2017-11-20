import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class WordSearch{
    private char[][] data;
    private static char[][] solution;
    private static ArrayList<String> wordsToAdd;
    private static ArrayList<String> wordsAdded;
    private Random randgen;
    private int seed;

    public WordSearch(int rows, int cols, String fileName, int seed){
        data  = new char[rows][cols];
        solution = new char[rows][cols];
        wordsToAdd = new ArrayList<>();
        wordsAdded = new ArrayList<>();
        this.seed = seed;
        randgen = new Random(seed);
        clear();
        getWords(fileName);
        addAllWords();
        addTrash();
    }

    public WordSearch(int rows, int cols, String fileName){
        data  = new char[rows][cols];
        solution = new char[rows][cols];
        wordsToAdd = new ArrayList<>();
        wordsAdded = new ArrayList<>();
        int seed = (int)(Math.random() * 1000);
        this.seed = seed;
        randgen = new Random(seed);
        clear();
        getWords(fileName);
        addAllWords();
        addTrash();
    }

    private void getWords(String fileName){
        try{
            File txt = new File(fileName);
            Scanner in = new Scanner(txt);

            while (in.hasNext()){
                String word = in.next();
                wordsToAdd.add(word);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + fileName);
            System.exit(1);
        }
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
        for (int i = 0; i < data.length; i++){
            for (int ii = 0; ii <data[i].length; ii++){
                data[i][ii] = '_';
            }
        }
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
        String box = "Puzzle ID: " + seed;
        for (int i = 0; i < data.length; i++){
            box += "\n";
            for (int ii = 0; ii < data[i].length; ii++){
                box += data[i][ii] + " ";
            }
        }
        box+= "\n\nWord Box";
        String wordBox = "";
        int maxWordLine = 5;
        for (int i = 0; i < wordsAdded.size(); i ++){
            if (i % maxWordLine == 0){
                wordBox += "\n";
            }
            wordBox += wordsAdded.get(i) + "  ";
        }
        return box + wordBox;
    }

    public String getSolution(){
        String box = "Puzzle ID: " + seed;
        for (int i = 0; i < solution.length; i++){
            box += "\n";
            for (int ii = 0; ii < solution[i].length; ii++){
                box += solution[i][ii] + " ";
            }
        }
        return box;
    }

     public boolean addWord(int row, int col, String word, int rowIncrement, int colIncrement){
         if (rowIncrement == 0 && colIncrement == 0){
             return false;
         }

         for (int i = 0; i < word.length(); i++) {
            int rowInd = row + rowIncrement * i;
            int colInd = col + colIncrement * i;
            try {   //ty jia for try-catch
                if (data[rowInd][colInd] != word.charAt(i) && data[rowInd][colInd] != '_') {
                    return false;
                }
            }catch(ArrayIndexOutOfBoundsException e) {
                return false;
            }
         }
         int wordIndex = 0;
         for (int i = 0; i < word.length(); i++){
             solution[row][col] = word.charAt(wordIndex);
             data[row][col] = word.charAt(wordIndex);
             wordIndex++;
             row += rowIncrement;
             col += colIncrement;
         }
         return true;
     }

     public String addedWords(){
         String wordsAddedtoPuzzle = "";
         for (int i = 0; i < wordsAdded.size(); i ++){
             wordsAddedtoPuzzle += wordsAdded.get(i) + "  ";
         }
         return wordsAddedtoPuzzle;
     }

     public int seedUsed(){
         return seed;
     }

     public boolean addAllWords(){
         for (int i = 0; i < wordsToAdd.size() * 100; i++){
            try{
                int randRemoveInd = randgen.nextInt(10000000) % wordsToAdd.size();
                if (addWord(randgen.nextInt(1000000) % data.length, randgen.nextInt(1000000) % data[0].length,
                wordsToAdd.get(randRemoveInd), randgen.nextInt(3) -1, randgen.nextInt(3) - 1)){
                    wordsAdded.add(wordsToAdd.remove(randRemoveInd));
                }
            }catch(ArithmeticException e){}
             catch(NullPointerException er){};
         }
         return true;
     }

     public void addTrash(){
        for (int i = 0; i < data.length; i++) {
            for (int ii = 0; ii < data[i].length; ii++) {
                if (data[i][ii] == '_') {
                    data[i][ii] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(randgen.nextInt(10000) % 26);
                }
            }
        }
     }

    public static void main(String[] args) {
        int rows = 0;
        int cols = 0;
        String fileName = "";
        int seed = 0;
        String solution = "";

        if (args.length == 0){
            System.out.println("***Please enter some arguments.*** \n\"java wordsearch [rows cols filename [randomSeed [answers]]]\" \n(Arguments in brackets are optional. Order Matters!!)");
        }

        if (args.length < 4 && args.length > 0){
            try{
                rows = Integer.parseInt(args[0]);
                cols = Integer.parseInt(args[1]);
                fileName = args[2];
            }catch(NumberFormatException e){
                    System.out.println("Integers only please.");
                    return;
             }
             catch(ArrayIndexOutOfBoundsException er){
                    System.out.println("Enter more information please.");
                    return;
            }
            WordSearch word = new WordSearch(rows, cols, fileName);
            System.out.println(word);
            return;
        }

        if (args.length > 3){
            try{
                rows = Integer.parseInt(args[0]);
                cols = Integer.parseInt(args[1]);
                fileName = args[2];
                seed = Integer.parseInt(args[3]);

            }catch(NumberFormatException e){
                    System.out.println("Integers only please.");
                    return;
             }
             catch(ArrayIndexOutOfBoundsException er){
                    System.out.println("Enter more information please.");
                    return;
            }
            try{
                solution = args[4];
            }catch(ArrayIndexOutOfBoundsException e){
                WordSearch word = new WordSearch(rows, cols, fileName, seed);
                System.out.println(word);
                return;
            }
            WordSearch word = new WordSearch (rows, cols, fileName, seed);
            if (args[4].equals("key")){
                System.out.println(word.getSolution());
                return;
            }
            System.out.println(word);
            return;
        }
    }
}
