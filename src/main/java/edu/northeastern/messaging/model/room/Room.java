package edu.northeastern.messaging.model.room;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;

/**
 * Room Entity
 */
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

    /**
     * Add a user to the room
     * 
     * @param userId the user id
     * @return true if the user was added, false otherwise
     */
    public boolean addUser(String userId) {
        return members.add(userId);
    }

    /**
     * Check if the room contains a user
     * 
     * @param userId the user id
     * @return true if the room contains the user, false otherwise
     */
    public boolean containsUser(String userId) {
        return members.contains(userId);
    }

    /**
     * Remove a user from the room
     * 
     * @param userId the user id
     * @return true if the user was removed, false otherwise
     */
    public boolean removeUser(String userId) {
        return members.remove(userId);
    }
}
