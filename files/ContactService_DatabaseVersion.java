package contacts;

import java.sql.SQLException;

public class ContactService_DatabaseVersion {

    private ContactDAO dao = new ContactDAO();

    public boolean addContact(Contact contact) {
        try {
            if (dao.getContact(contact.getContactId()) != null) {
                return false; // duplicate
            }
            dao.insertContact(contact);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteContact(String contactId) {
        try {
            dao.deleteContact(contactId);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateFirstName(String contactId, String newFirstName) {
        try {
            Contact c = dao.getContact(contactId);
            if (c == null) return false;

            c.setFirstName(newFirstName);
            dao.updateContact(c);
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateLastName(String contactId, String newLastName) {
        try {
            Contact c = dao.getContact(contactId);
            if (c == null) return false;

            c.setLastName(newLastName);
            dao.updateContact(c);
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updatePhone(String contactId, String newPhone) {
        try {
            Contact c = dao.getContact(contactId);
            if (c == null) return false;

            c.setPhone(newPhone);
            dao.updateContact(c);
            return true;

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean updateAddress(String contactId, String newAddress) {
        try {
            Contact c = dao.getContact(contactId);
            if (c == null) return false;

            c.setAddress(newAddress);
            dao.updateContact(c);
            return true;

        } catch (SQLException e) {
            return false;
        }
    }
}
