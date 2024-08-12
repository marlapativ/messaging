package edu.northeastern.messaging.service.metrics;

/**
 * Observer Interface
 */
public interface Observer {

    /**
     * Update Metric
     * 
     * @param metricType The metric type
     */
    void updateMetric(Metric.Type metricType);
}
