public class CirculatingBook extends LibraryBook{

    String currentHolder;
    String dueDate;
    boolean checkedOut;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
        super(author, title, ISBN, callNumber);
    }

    public String getCurrentHolder(){return currentHolder;}
    public String getDueDate(){return dueDate;}
    public void setCurrentHolder(String holder){currentHolder = holder;}
    public void setDueDate(String date){dueDate = date;}

    public void checkout(String patron, String due){
        checkedOut = true;
        currentHolder = patron;
        dueDate = due;
    }

    public void returned(){
        checkedOut = false;
        currentHolder = null;
        dueDate = null;
    }

    public String circulationStatus(){
        if (checkedOut){
            return currentHolder + "\t" + dueDate;
        }else{
            return "book available on shelves";
        }
    }

    public String toString(){
        if (checkedOut){
            return super.toString() + "," + currentHolder + "," + dueDate;
        }else{
            return super.toString();
        }
    }

}
