package com.hfad.fragrecyclerep.model;

public class Notes {
    private String name;
    private String Description;
    private int pictures; //храним идентификатор картинки в ресурсах
    private int date;
    private boolean like;

    public boolean isLike() {
        return like;
    }

    public Notes(String name, String description, int pictures, boolean like) {
        this.name = name;
        Description = description;
        this.pictures = pictures;
        this.like = like;
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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPictures() {
        return pictures;
    }

    public void setPictures(int pictures) {
        this.pictures = pictures;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
