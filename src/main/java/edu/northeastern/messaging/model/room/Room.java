package edu.northeastern.messaging.model.room;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

@Getter
public abstract class Room {
    protected String id;
    protected String name;
    protected Set<String> members;

    public Room(String id, String name) {
        this.id = id;
        this.name = name;
        this.members = new HashSet<>();
    }

    public abstract RoomType getType();

    public boolean addUser(String userId) {
        return members.add(userId);
    }

    public boolean containsUser(String userId) {
        return members.contains(userId);
    }

    public boolean removeUser(String userId) {
        return members.remove(userId);
    }
}
