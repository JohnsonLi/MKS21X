class Book{
    private String author;
    private String title;
    private String ISBN;
    
    public Book(){
    }
    
    public Book(String author, String title, String ISBN){
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
    }

    public String getAuthor(){return author;}
    public String getTitle(){return title;}
    public String getISBN(){return ISBN;}

    public void setAuthor(String author){this.author = author;}
    public void setTitle(String title){this.title = title;}
    public void setISBN(String ISBN){this.ISBN = ISBN;}

    public String toString(String author, String title, String ISBN){
        return title + " by " + author + "\nISBN: " + ISBN + "\n";  
    }

    public static void main(String[] args){
        Book book =  new Book("hi", "me", "123");
        System.out.println(book);
    }
}
