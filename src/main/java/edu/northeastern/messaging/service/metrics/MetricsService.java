package edu.northeastern.messaging.service.metrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.northeastern.messaging.service.metrics.types.AbstractMetricFactory;
import edu.northeastern.messaging.service.metrics.types.CurrentSessionMetricFactory;
import edu.northeastern.messaging.service.metrics.types.TotalMetricFactory;

/**
 * Metrics Service
 */
public enum MetricsService {
    PUBLISHER;

    private final MetricsPublisher METRICS_PUBLISHER = new MetricsPublisher();

    private List<Metric> metrics = new ArrayList<>();

    MetricsService() {
        // Add the current session metrics observers to the publisher
        AbstractMetricFactory currentSession = new CurrentSessionMetricFactory();
        metrics.add(currentSession.createMessagesMetric());
        metrics.add(currentSession.createUsersMetric());

        // Add the total metrics observers to the publisher
        AbstractMetricFactory totals = new TotalMetricFactory();
        metrics.add(totals.createMessagesMetric());
        metrics.add(totals.createUsersMetric());

        // Add all the metrics to the publisher
        for (Metric metric : metrics) {
            METRICS_PUBLISHER.addObserver(metric);
        }
    }

    /**
     * Get the metrics publisher
     * 
     * @return The metrics publisher
     */
    public MetricsPublisher get() {
        return METRICS_PUBLISHER;
    }

    /**
     * Get the metrics
     */
    public Map<String, Integer> getMetrics() {
        Map<String, Integer> metricsMap = new HashMap<>();
        for (Metric metric : metrics) {
            metricsMap.put(metric.getName(), metric.getValue());
        }
        return metricsMap;
    }
}
