public class PrintedBook extends Book {
    public PrintedBook(int id, String title, String author) {
        super(title, author, String.valueOf(id));
    }
    // Конструктор для старого Main (где 3 строки)
    public PrintedBook(String title, String author, String id) {
        super(title, author, id);
    }
    @Override
    public void printInfo() { System.out.println("Printed: " + getTitle()); }
}