public class Library {
    private String name;
    private Book[] books;
    private int bookCount;

    public Library(String name, int size) {
        this.name = name;
        this.books = new Book[size];
        this.bookCount = 0;
    }

    public void addBook(Book b) {
        if (bookCount < books.length) books[bookCount++] = b;
    }

    public void borrowBooks(String title, LibraryUser user) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title) && books[i].getBorrowedBy() == null) {
                books[i].setBorrowedBy(user);
                System.out.println(user.getName() + " took " + title);
                return;
            }
        }
    }

    public void returnBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                books[i].setBorrowedBy(null);
                System.out.println(title + " returned");
                return;
            }
        }
    }
    public void printStats() {
        int taken = 0;
        for (int i = 0; i < bookCount; i++) if (books[i].getBorrowedBy() != null) taken++;
        System.out.println("Total: " + bookCount + ", Taken: " + taken);
    }

    public void printAllBooks() {
        for (int i = 0; i < bookCount; i++) books[i].printInfo();
    }
}