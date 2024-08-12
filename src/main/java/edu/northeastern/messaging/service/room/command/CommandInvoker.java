package edu.northeastern.messaging.service.room.command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Command Invoker
 */
public class CommandInvoker {
    private final Queue<Command> commandQueue = new LinkedList<>();

    public void addCommand(Command command) {
        commandQueue.offer(command);
    }

    public void executeCommands() {
        while (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
        }
    }
}
