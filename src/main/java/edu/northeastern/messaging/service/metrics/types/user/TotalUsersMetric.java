package edu.northeastern.messaging.service.metrics.types.user;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import edu.northeastern.messaging.service.metrics.Metric;

/**
 * Total Users Metric
 */
public class TotalUsersMetric implements Metric {

    protected int userCount;

    public TotalUsersMetric() {
        Path userCountFile = Paths.get("userCount.txt");
        if (Files.exists(userCountFile)) {
            try (var reader = Files.newBufferedReader(userCountFile)) {
                userCount = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                userCount = 0;
            }
        } else {
            userCount = 0;
        }
    }

    @Override
    public String getName() {
        return "Total Users";
    }

    @Override
    public int getValue() {
        return userCount;
    }

    @Override
    public void increment() {
        userCount++;
        updateFile();
    }

    @Override
    public void decrement() {
    }

    private void updateFile() {
        if (userCount <= 0) {
            return;
        }

        Path path = Paths.get("userCount.txt");
        // Overrwite the file with the new message count
        try (var writer = Files.newBufferedWriter(path)) {
            writer.write(Integer.toString(userCount));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMetric(Type metricType) {
        if (metricType == Type.USER_ADD) {
            increment();
        } else if (metricType == Type.USER_REMOVE) {
            decrement();
        }
    }
}
