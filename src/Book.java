public  abstract class Book {
    private String title;
    private String author;
    private String isbn;
    private LibraryUser borrowedBy; // кто взял книгу

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowedBy = null;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public LibraryUser getBorrowedBy() { return borrowedBy; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    // Метод — взять книгу
    public boolean borrow(LibraryUser user) {
        if (borrowedBy == null) {
            borrowedBy = user;
            return true;
        }
        return false;
    }
    public void returnBook(){
        borrowedBy=null;
    }
    public abstract String getType();
    @Override
    public String toString(){
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", status=" + (borrowedBy == null ? "Available" : "Taken by " + borrowedBy.getName()) +
                '}';
    }
  @Override
  public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Book)) return false;
      Book book = (Book) o;
      return isbn.equals(book.isbn);
  }
    public void printInfo() {
        System.out.print("Book: " + title + " | " + author + " | ISBN: " + isbn);
        if (borrowedBy != null) {
            System.out.println(" | Taken by: " + borrowedBy.getName());
        } else {
            System.out.println(" | Available");
        }
    }
}


