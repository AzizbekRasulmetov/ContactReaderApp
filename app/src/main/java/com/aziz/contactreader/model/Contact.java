package com.aziz.contactreader.model;

import android.graphics.Bitmap;
import android.net.Uri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact_table")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    int key;
    public String name;
    @ColumnInfo(name = "mobile_number")
    public String mobileNumber;
    @Ignore
    public Bitmap photo;
    @Ignore
    //@ColumnInfo(name = "photo_uri")
    public Uri photoURI;

    @Ignore
    public Contact(String name, String mobileNumber, Bitmap photo, Uri photoURI){
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.photo = photo;
        this.photoURI = photoURI;
    }

    public Contact(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public Uri getPhotoURI() {
        return photoURI;
    }
}
