package com.aziz.contactreader.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.aziz.contactreader.model.Contact;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ContactDao {

    @Insert
    Completable insert(List<Contact> contacts);

    @Delete
    Completable delete(Contact contact);

    @Query("SELECT * FROM contact_table")
    Single<List<Contact>> getAllContacts();

    @Query("DELETE FROM contact_table")
    Completable deleteAllContacts();
}
