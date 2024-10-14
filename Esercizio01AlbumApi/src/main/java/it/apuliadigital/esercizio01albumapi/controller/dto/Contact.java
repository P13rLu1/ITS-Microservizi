package it.apuliadigital.esercizio01albumapi.controller.dto;

import java.util.Objects;

public class Contact {

    private String contactType;
    private String contact;

    public Contact() {
    }

    public Contact(String contactType, String contact) {
        this.contactType = contactType;
        this.contact = contact;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact1 = (Contact) o;
        return Objects.equals(contactType, contact1.contactType) && Objects.equals(contact, contact1.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactType, contact);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactType='" + contactType + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
