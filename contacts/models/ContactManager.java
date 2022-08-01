package models;

import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts;

    public ContactManager(){
        contacts = new ArrayList<Contact>();
    }

    public Contact getContact(int index){
        return new Contact(contacts.get(index));
    }

    public void setContact(int index, Contact contact){
        this.contacts.add(index, new Contact(contact));
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public void removeContact(String contactName){
        if(this.contacts.isEmpty()){
            throw new IllegalStateException("Cannot remove from empty list");
        }

        for(int i=0;i<this.contacts.size();i++){
            if(this.contacts.get(i).getName().equals(contactName)){
                this.contacts.remove(i);
                break;
            }
        }
    }

    public String toString(){
        String temp="";

        for (int i = 0; i < this.contacts.size(); i++) {
            temp+=this.contacts.get(i).toString();
            temp+="\n\n";
        }

        return temp;
    }
}
