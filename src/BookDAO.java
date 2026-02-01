import java.sql.*;

public class BookDAO {
    public static void saveBook(Book book) {
        String sql = "INSERT INTO books (id, title, author, book_type, pages, file_size) " +
                "VALUES (?, ?, ?, ?, ?, ?) " +
                "ON CONFLICT (id) DO UPDATE SET title = EXCLUDED.title, author = EXCLUDED.author";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // ВАЖНО: используем setString, так как в классе Book id теперь String
            ps.setString(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());

            if (book instanceof PrintedBook) {
                ps.setString(4, "PRINTED");
                // Если в PrintedBook нет поля pages, ставим 0 или заглушку
                ps.setInt(5, 0);
                ps.setNull(6, Types.DOUBLE);
            } else if (book instanceof EBook) {
                ps.setString(4, "EBOOK");
                ps.setNull(5, Types.INTEGER);
                // Если в EBook нет поля fileSize, ставим 0.0
                ps.setDouble(6, 0.0);
            }

            ps.executeUpdate();
            System.out.println("Book is saved in DB: " + book.getTitle());
        } catch (SQLException e) {
            System.err.println("Error saving the book: " + e.getMessage());
        }
    }
}