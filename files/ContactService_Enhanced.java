package contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        // Prevent duplicate IDs
        if (contacts.containsKey(contact.getContactId())) {
            return false;
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    public boolean deleteContact(String contactId) {
        return contacts.remove(contactId) != null;
    }

    public boolean updateFirstName(String contactId, String newFirstName) {
        Contact c = contacts.get(contactId);
        if (c != null) {
            c.setFirstName(newFirstName);
            return true;
        }
        return false;
    }

    public boolean updateLastName(String contactId, String newLastName) {
        Contact c = contacts.get(contactId);
        if (c != null) {
            c.setLastName(newLastName);
            return true;
        }
        return false;
    }

    public boolean updatePhone(String contactId, String newPhone) {
        Contact c = contacts.get(contactId);
        if (c != null) {
            c.setPhone(newPhone);
            return true;
        }
        return false;
    }

    public boolean updateAddress(String contactId, String newAddress) {
        Contact c = contacts.get(contactId);
        if (c != null) {
            c.setAddress(newAddress);
            return true;
        }
        return false;
    }
}
