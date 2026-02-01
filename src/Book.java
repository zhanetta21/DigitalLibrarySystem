public abstract class Book {
    private String title;
    private String author;
    private String id;
    private LibraryUser borrowedBy;

    public Book(String title, String author, String id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getId() { return id; }
    public LibraryUser getBorrowedBy() { return borrowedBy; }

    public void setBorrowedBy(LibraryUser user) { this.borrowedBy = user; }

    public abstract void printInfo();
}