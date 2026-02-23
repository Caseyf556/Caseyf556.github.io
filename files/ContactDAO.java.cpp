import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public boolean insertContact(Contact contact) {
        String sql = "INSERT INTO contacts(contact_id, first_name, last_name, phone, address) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contact.getContactId());
            stmt.setString(2, contact.getFirstName());
            stmt.setString(3, contact.getLastName());
            stmt.setString(4, contact.getPhone());
            stmt.setString(5, contact.getAddress());

            stmt.executeUpdate();
            return true;

        }
        catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteContact(String contactId) {
        String sql = "DELETE FROM contacts WHERE contact_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contactId);
            return stmt.executeUpdate() > 0;

        }
        catch (SQLException e) {
            return false;
        }
    }

    public boolean updateField(String contactId, String field, String value) {
        String sql = "UPDATE contacts SET " + field + " = ? WHERE contact_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, value);
            stmt.setString(2, contactId);
            return stmt.executeUpdate() > 0;

        }
        catch (SQLException e) {
            return false;
        }
    }

    public Contact getContactById(String contactId) {
        String sql = "SELECT * FROM contacts WHERE contact_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contactId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Contact(
                    rs.getString("contact_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("phone"),
                    rs.getString("address")
                );
            }

        }
        catch (SQLException e) {
            return null;
        }

        return null;
    }
}
