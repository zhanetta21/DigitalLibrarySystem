public class MainDB {
    public static void main(String[] args) {
        // 1. Тест связи
        DBConnection.testConnection();

        // 2. Создаем книги (Обрати внимание на порядок: id, title, author, param)
        PrintedBook pBook = new PrintedBook("Java Beginner", "John Smith", "10");
        EBook eBook = new EBook("Digital Era", "Jane Doe", "20");

        // 3. Сохраняем (Write)
        BookDAO.saveBook(pBook);
        BookDAO.saveBook(eBook);

        System.out.println("Done!");
    }
}