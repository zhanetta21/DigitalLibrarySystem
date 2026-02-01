import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // Method to Save or Update a book in the Database
    public static void saveBook(Book book) {
        // The SQL query handles both insert and update (Upsert)
        String sql = "INSERT INTO books (id, title, author, book_type, pages, file_size) " +
                "VALUES (?, ?, ?, ?, ?, ?) " +
                "ON CONFLICT (id) DO UPDATE SET title = EXCLUDED.title, author = EXCLUDED.author";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Setting standard book parameters
            ps.setString(1, book.getId());     // ID must be VARCHAR in DB
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());

            // Handling specific book types using Polymorphism
            if (book instanceof PrintedBook) {
                ps.setString(4, "PRINTED");
                ps.setInt(5, 0);               // Placeholder for pages
                ps.setNull(6, Types.DOUBLE);
            } else if (book instanceof EBook) {
                ps.setString(4, "EBOOK");
                ps.setNull(5, Types.INTEGER);
                ps.setDouble(6, 0.0);          // Placeholder for file size
            }
            ps.executeUpdate();
            System.out.println("Successfully processed: " + book.getTitle());

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    // Method to Fetch all books (Required for the REST API/JSON part)
    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String type = rs.getString("book_type");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String id = rs.getString("id");

                if ("PRINTED".equals(type)) {
                    books.add(new PrintedBook(title, author, id));
                } else {
                    books.add(new EBook(title, author, id));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}