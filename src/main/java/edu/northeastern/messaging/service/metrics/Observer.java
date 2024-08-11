package edu.northeastern.messaging.service.metrics;

public interface Observer {
    void updateMetric(Metric.Type metricType);
}
