import java.sql.*;

public class UserDAO {
    public static void addUser(LibraryUser user) {
        String sql = "INSERT INTO library_user (user_id, name) VALUES (?, ?) " +
                "ON CONFLICT (user_id) DO UPDATE SET name = EXCLUDED.name";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getName());
            ps.executeUpdate();
            System.out.println("User processed: " + user.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}