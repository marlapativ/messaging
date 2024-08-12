package edu.northeastern.messaging.service.metrics;

import java.util.ArrayList;
import java.util.List;

/**
 * Metrics Publisher
 */
public class MetricsPublisher {
    private List<Observer> observers = new ArrayList<>();

    /**
     * Add an observer
     * 
     * @param observer The observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Remove an observer
     * 
     * @param observer The observer
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Publish a metric
     * 
     * @param metricType The metric type
     */
    public void publish(Metric.Type metricType) {
        notifyObservers(metricType);
    }

    /**
     * Notify observers
     * 
     * @param metricType The metric type
     */
    private void notifyObservers(Metric.Type metricType) {
        for (Observer observer : observers) {
            observer.updateMetric(metricType);
        }
    }
}
