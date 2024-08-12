package edu.northeastern.messaging.repository.strategy;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import edu.northeastern.messaging.model.message.Message;

/**
 * File Persistence Strategy
 */
public class FilePersistenceStrategy implements MessagePersistenceStrategy {
    private static final String FILE_PATH = "chat_messages.txt";

    @Override
    public void saveMessage(Message message) {
        try {
            var path = Paths.get(FILE_PATH);
            JsonElement messages = new JsonArray();
            if (Files.exists(path)) {
                var data = Files.readAllBytes(path).toString();
                messages = JsonParser.parseString(data);
            }
            var jsonMsg = new Gson().toJsonTree(message);
            messages.getAsJsonArray().add(jsonMsg);

            try (var writer = new FileWriter(FILE_PATH)) {
                writer.write(messages.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Message> getMessages() {
        try {
            var path = Paths.get(FILE_PATH);
            JsonElement messages = new JsonArray();
            if (Files.exists(path)) {
                var data = Files.readAllBytes(path).toString();
                messages = JsonParser.parseString(data);
            }
            Type listType = new TypeToken<ArrayList<Message>>() {
            }.getType();
            return new Gson().fromJson(messages, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
