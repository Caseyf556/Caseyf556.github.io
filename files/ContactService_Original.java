package contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private List<Contact> contacts = new ArrayList<>();

    public boolean addContact(Contact contact) {
        // Prevent duplicate IDs
        for (Contact c : contacts) {
            if (c.getContactId().equals(contact.getContactId())) {
                return false;
            }
        }
        contacts.add(contact);
        return true;
    }

    public boolean deleteContact(String contactId) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                contacts.remove(c);
                return true;
            }
        }
        return false;
    }

    public boolean updateFirstName(String contactId, String newFirstName) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setFirstName(newFirstName);
                return true;
            }
        }
        return false;
    }

    public boolean updateLastName(String contactId, String newLastName) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setLastName(newLastName);
                return true;
            }
        }
        return false;
    }

    public boolean updatePhone(String contactId, String newPhone) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setPhone(newPhone);
                return true;
            }
        }
        return false;
    }

    public boolean updateAddress(String contactId, String newAddress) {
        for (Contact c : contacts) {
            if (c.getContactId().equals(contactId)) {
                c.setAddress(newAddress);
                return true;
            }
        }
        return false;
    }
}
