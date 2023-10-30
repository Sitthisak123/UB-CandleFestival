package com.example.ubcandlefest.model;

public class Image {
    private int id;
    private String templeName;
    private String imageName;

    public Image() {
    }
    public Image(int id, String templeName, String imageName) {
        this.id = id;
        this.templeName = templeName;
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTempleName() {
        return templeName;
    }

    public void setTempleName(String templeName) {
        this.templeName = templeName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
