package models;

import java.util.List;

public class Room {
    int id;
    int cap;
    List<String> properties;

    public Room(int id, int cap, List<String> properties) {
        this.id = id;
        this.properties = properties;
        this.cap = cap;
    }

    public void addProperties(String prop) {
        properties.add(prop);
    }
}
