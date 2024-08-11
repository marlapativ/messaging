package edu.northeastern.messaging.service.metrics;

import java.util.ArrayList;
import java.util.List;

public class MetricsPublisher {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void publish(Metric.Type metricType) {
        notifyObservers(metricType);
    }

    private void notifyObservers(Metric.Type metricType) {
        for (Observer observer : observers) {
            observer.updateMetric(metricType);
        }
    }
}
