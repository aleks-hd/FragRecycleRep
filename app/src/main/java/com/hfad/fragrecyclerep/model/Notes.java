package com.hfad.fragrecyclerep.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Notes implements Parcelable {
    private String name;
    private String description;
    private int pictures; //храним идентификатор картинки в ресурсах
    private Date date;
    private boolean like;

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public boolean isLike() {
        return like;
    }

    public Notes(String name, String description, int pictures, Date date, boolean like) {
        this.name = name;
        this.description = description;
        this.pictures = pictures;
        this.date = date;
        this.like = like;
    }

    public Notes(String name, String description, int pictures, boolean like) {
        this.name = name;
        description = description;
        this.pictures = pictures;
        this.like = like;
    }

    public Notes(Parcel in){
        name = in.readString();
        description = in.readString();
        pictures = in.readInt();
        like = in.readByte() != 0;
        date = new Date(in.readLong());

    }



    public void setLike(boolean like) {
        this.like = like;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public int getPictures() {
        return pictures;
    }

    public void setPictures(int pictures) {
        this.pictures = pictures;
    }

    public Date getDate() {
        return date;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(pictures);
        parcel.writeByte((byte) (like?1:0));
        parcel.writeLong(date.getTime());
    }
}
