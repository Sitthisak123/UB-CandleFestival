package com.example.ubcandlefest.model;

public class Temple {
    private int id;

    public Temple(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Temple(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Temple() {
    }

    @Override
    public String toString() {
        return name;
    }

    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.description = description;
    }

    public static class get extends Temple {
        public get(int position) {
        }
    }
}
