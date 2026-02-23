package contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (contact == null || contact.getContactId() == null) {
            return false;
        }

        // Prevent duplicate IDs
        if (contacts.containsKey(contact.getContactId())) {
            return false;
        }

        contacts.put(contact.getContactId(), contact);
        return true;
    }

    public boolean deleteContact(String contactId) {
        if (contactId == null || !contacts.containsKey(contactId)) {
            return false;
        }

        contacts.remove(contactId);
        return true;
    }

    public boolean updateFirstName(String contactId, String newFirstName) {
        Contact c = contacts.get(contactId);
        if (c == null) {
            return false;
        }

        if (newFirstName == null || newFirstName.length() > 10) {
            return false;
        }

        c.setFirstName(newFirstName);
        return true;
    }

    public boolean updateLastName(String contactId, String newLastName) {
        Contact c = contacts.get(contactId);
        if (c == null) {
            return false;
        }

        if (newLastName == null || newLastName.length() > 10) {
            return false;
        }

        c.setLastName(newLastName);
        return true;
    }

    public boolean updatePhone(String contactId, String newPhone) {
        Contact c = contacts.get(contactId);
        if (c == null) {
            return false;
        }

        if (newPhone == null || newPhone.length() != 10) {
            return false;
        }

        c.setPhone(newPhone);
        return true;
    }

    public boolean updateAddress(String contactId, String newAddress) {
        Contact c = contacts.get(contactId);
        if (c == null) {
            return false;
        }

        if (newAddress == null || newAddress.length() > 30) {
            return false;
        }

        c.setAddress(newAddress);
        return true;
    }
}