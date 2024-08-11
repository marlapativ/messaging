package edu.northeastern.messaging.service.metrics.types;

import edu.northeastern.messaging.service.metrics.Metric;

public abstract class AbstractMetricFactory {

    public abstract Metric createUsersMetric();

    public abstract Metric createMessagesMetric();
}
