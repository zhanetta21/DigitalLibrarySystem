public class Main {
  public static void main(String[] args) {

    Library library = new Library("City Library", 10);
    Book b1 = new PrintedBook("1984", "George Orwell", "1");
    Book b2 = new PrintedBook("Harry Potter", "J.K. Rowling", "2");
    Book b3 = new EBook("The Hobbit", "J.R.R. Tolkien", "3");
    Book b4 = new PrintedBook("ABC Murders", "Agatha Christie", "4");

    library.addBook(b1);
    library.addBook(b2);
    library.addBook(b3);
    library.addBook(b4);

    LibraryUser u1 = new LibraryUser("Alice", 101);
    LibraryUser u2 = new LibraryUser("Bob", 102);

    library.borrowBooks("Harry Potter", u1);
    library.borrowBooks("1984", u2);

    library.printAllBooks();
    library.printStats();

    library.returnBook("Harry Potter");
    library.printAllBooks();
    library.printStats();
  }
}


