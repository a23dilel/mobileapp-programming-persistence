package com.example.persistence;

@SuppressWarnings("WeakerAccess")
public class Data {
    private String id;
    private String name;
    private String location;

    public Data(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getLocation() {
        return this.location;
    }

    public void setID(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
