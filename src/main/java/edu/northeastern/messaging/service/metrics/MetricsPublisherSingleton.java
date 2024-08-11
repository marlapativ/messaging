package edu.northeastern.messaging.service.metrics;

import edu.northeastern.messaging.service.metrics.types.AbstractMetricFactory;
import edu.northeastern.messaging.service.metrics.types.CurrentSessionMetricFactory;
import edu.northeastern.messaging.service.metrics.types.TotalMetricFactory;

public enum MetricsPublisherSingleton {
    INSTANCE;

    private final MetricsPublisher PUBLISHER = new MetricsPublisher();

    MetricsPublisherSingleton() {
        // Add the current session metrics observers to the publisher
        AbstractMetricFactory currentSession = new CurrentSessionMetricFactory();
        PUBLISHER.addObserver(currentSession.createMessagesMetric());
        PUBLISHER.addObserver(currentSession.createUsersMetric());

        // Add the total metrics observers to the publisher
        AbstractMetricFactory totals = new TotalMetricFactory();
        PUBLISHER.addObserver(totals.createMessagesMetric());
        PUBLISHER.addObserver(totals.createUsersMetric());
    }

    public MetricsPublisher get() {
        return PUBLISHER;
    }
}
