package com.aziz.contactreader.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.aziz.contactreader.model.Contact;
import com.aziz.contactreader.repository.ContactRepository;

import java.util.List;

import io.reactivex.Single;

public class ContactViewModel extends AndroidViewModel {

    private ContactRepository repository;
    private Single<List<Contact>> allContacts;

    public ContactViewModel(Application application) {
        super(application);
        repository = new ContactRepository(application);
        allContacts = repository.getAllContacts();
    }

    public void insert(List<Contact> contacts) {
        repository.insert(contacts);
    }

    public void delete(Contact contact) {
        repository.delete(contact);
    }

    public void deleteAllContacts() {
        repository.deleteAllContacts();
    }

    public Single<List<Contact>> getAllContacts() {
        return allContacts;
    }


}
