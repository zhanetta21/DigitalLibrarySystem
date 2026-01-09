import java.sql.*;
public class UserDAO {
    public static void addUser(LibraryUser user) {
        // Добавлена конструкция ON CONFLICT
        String sql = "INSERT INTO library_user (user_id, name) VALUES (?, ?) " +
                "ON CONFLICT (user_id) DO UPDATE SET name = EXCLUDED.name";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, user.getUserId());
            ps.setString(2, user.getName());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении пользователя: " + e.getMessage());
        }
    }
    public static void getAllUsers() {
        String sql = "SELECT * FROM library_user";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("user_id") + " | " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateUserName(int userId, String newName) {
        String sql = "UPDATE library_user SET name = ? WHERE user_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteUser(int userId) {
        String sql = "DELETE FROM library_user WHERE user_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}