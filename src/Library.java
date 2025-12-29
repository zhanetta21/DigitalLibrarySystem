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
        if (bookCount < books.length) {
            books[bookCount] = b;
            bookCount++;
        } else {
            System.out.println("Library is full.");
        }
    }

    public Book findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public void borrowBooks(String title, LibraryUser user) {
        Book b = findBook(title);

        if (b == null) {
            System.out.println("The book \"" + title + "\" not found.");
            return;
        }

        if (b.borrow(user)) {
            System.out.println(user.getName() + " took \"" + title + "\"");
        } else {
            System.out.println("This book is already taken by " + b.getBorrowedBy().getName());
        }
    }

    public void returnBook(String title) {
        Book b = findBook(title);

        if (b == null) {
            System.out.println("The book \"" + title + "\" was not found.");
            return;
        }

        if (b.getBorrowedBy() != null) {
            System.out.println(b.getBorrowedBy().getName() + " returned \"" + title + "\"");
            b.returnBook();
        } else {
            System.out.println("The book is already free.");
        }
    }

    public void sortByTitle() {
        for (int i = 0; i < bookCount - 1; i++) {
            for (int j = i + 1; j < bookCount; j++) {
                if (books[i].getTitle().compareToIgnoreCase(books[j].getTitle()) > 0) {
                    Book temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
    }

    public void printAvailableBooks() {
        System.out.println("\nAvailable books:");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBorrowedBy() == null) {
                books[i].printInfo();
            }
        }
    }


    public void printAllBooks() {
        System.out.println("\nBooks in library \"" + name + "\":");
        for (int i = 0; i < bookCount; i++) {
            books[i].printInfo();
        }
    }

    public void printStats() {
        int borrowed = 0;

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBorrowedBy() != null) {
                borrowed++;
            }
        }

        int available = bookCount - borrowed;

        System.out.println("\nLibrary statistics \"" + name + "\":");
        System.out.println("Total books: " + bookCount);
        System.out.println("Taken books: " + borrowed);
        System.out.println("Available books: " + available);
    }
}


