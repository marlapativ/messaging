package edu.northeastern.messaging.model.room;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Room {
    private String id;
    private String name;
}
