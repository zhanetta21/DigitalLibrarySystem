import java.sql.*;
public class BookDAO {
    public static void addBook(Book book) {
        String sql = "INSERT INTO book (isbn, title, author, type) VALUES (?, ?, ?, ?) " +
                "ON CONFLICT (isbn) DO NOTHING";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            String type = (book instanceof PrintedBook) ? "Printed book" : "Electronic book";
            ps.setString(4, type);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void getAllBooks() {
        String sql = "SELECT * FROM book";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getString("type") + " | borrowed by: " +
                                rs.getInt("borrowed_by")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // МЕТОД ВЫДАЧИ КНИГИ (borrowBook)
    public static void borrowBook(String isbn, int userId) {
        String sql = "UPDATE book SET borrowed_by = ? WHERE isbn = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, isbn);
            ps.executeUpdate();
            System.out.println("Книга с ISBN " + isbn + " выдана пользователю " + userId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // МЕТОД ВОЗВРАТА КНИГИ (returnBook)
    public static void returnBook(String isbn) {
        String sql = "UPDATE book SET borrowed_by = NULL WHERE isbn = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, isbn);
            ps.executeUpdate();
            System.out.println("Книга с ISBN " + isbn + " возвращена в библиотеку.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // МЕТОД УДАЛЕНИЯ КНИГИ
    public static void deleteBook(String isbn) {
        String sql = "DELETE FROM book WHERE isbn = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, isbn);
            ps.executeUpdate();
            System.out.println("Книга с ISBN " + isbn + " удалена.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}