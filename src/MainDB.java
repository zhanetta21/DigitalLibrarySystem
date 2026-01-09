public class MainDB {
    public static void main(String[] args) {
        // USERS
        LibraryUser u1 = new LibraryUser("Alice", 101);
        LibraryUser u2 = new LibraryUser("Bob", 102);
        UserDAO.addUser(u1);
        UserDAO.addUser(u2);
        // BOOKS
        Book b1 = new PrintedBook("1984", "George Orwell", "1");
        Book b2 = new PrintedBook("Harry Potter", "J.K. Rowling", "2");
        Book b3 = new EBook("The Hobbit", "J.R.R. Tolkien", "3");
        BookDAO.addBook(b1);
        BookDAO.addBook(b2);
        BookDAO.addBook(b3);
        // READ
        BookDAO.getAllBooks();
        // UPDATE
        BookDAO.borrowBook("2", 101);
        BookDAO.returnBook("2");
        // DELETE
        BookDAO.deleteBook("3");
        UserDAO.deleteUser(102);
    }
}
