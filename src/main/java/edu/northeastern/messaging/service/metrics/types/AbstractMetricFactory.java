package edu.northeastern.messaging.service.metrics.types;

import edu.northeastern.messaging.service.metrics.Metric;

/**
 * Abstract Metric Factory
 */
public abstract class AbstractMetricFactory {

    /**
     * Create Users Metric
     * 
     * @return The users metric
     */
    public abstract Metric createUsersMetric();

    /**
     * Create Messages Metric
     * 
     * @return The messages metric
     */
    public abstract Metric createMessagesMetric();
}
