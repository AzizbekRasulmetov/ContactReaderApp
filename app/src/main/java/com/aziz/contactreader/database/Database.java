package com.aziz.contactreader.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.aziz.contactreader.model.Contact;

@androidx.room.Database(entities = Contact.class, version = 1)
public abstract class Database extends RoomDatabase {

    public static Database instance;

    public abstract ContactDao contactDao();

    public static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "contact_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
