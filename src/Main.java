public class Main {
  public static void main(String[] args) {

    Library library = new Library("City Library", 10);

    Book b1 = new Book("1984", "George Orwell", "1111");
    Book b2 = new Book("Harry Potter", "J.K. Rowling", "2222");
    Book b3 = new Book("The Hobbit", "J.R.R. Tolkien", "3333");

    library.addBook(b1);
    library.addBook(b2);
    library.addBook(b3);

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


