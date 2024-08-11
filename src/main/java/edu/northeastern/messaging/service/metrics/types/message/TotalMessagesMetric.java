package edu.northeastern.messaging.service.metrics.types.message;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import edu.northeastern.messaging.service.metrics.Metric;

public class TotalMessagesMetric implements Metric {

    protected int messageCount;

    public TotalMessagesMetric() {
        Path path = Paths.get("messageCount.txt");
        if (Files.exists(path)) {
            try (var reader = Files.newBufferedReader(path)) {
                messageCount = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                messageCount = 0;
            }
        } else {
            messageCount = 0;
        }
    }

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public int getValue() {
        return messageCount;
    }

    @Override
    public void increment() {
        messageCount++;
        updateFile();
    }

    private void updateFile() {
        if (messageCount <= 0) {
            return;
        }

        Path path = Paths.get("messageCount.txt");
        // Overrwite the file with the new message count
        try (var writer = Files.newBufferedWriter(path)) {
            writer.write(Integer.toString(messageCount));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decrement() {
    }

    @Override
    public void updateMetric(Type metricType) {
        if (metricType == Type.MESSAGE_ADD) {
            increment();
        } else if (metricType == Type.MESSAGE_REMOVE) {
            decrement();
        }
    }
}
