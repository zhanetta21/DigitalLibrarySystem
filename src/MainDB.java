public class MainDB {
    public static void main(String[] args) {
        DBConnection.testConnection();

        PrintedBook pBook = new PrintedBook("Java Beginner", "John Smith", "10");
        EBook eBook = new EBook("Digital Era", "Jane Doe", "20");

        BookDAO.saveBook(pBook);
        BookDAO.saveBook(eBook);

        System.out.println("Done!");
    }
}