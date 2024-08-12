package edu.northeastern.messaging.service.metrics.types;

import edu.northeastern.messaging.service.metrics.Metric;
import edu.northeastern.messaging.service.metrics.types.message.TotalMessagesMetric;
import edu.northeastern.messaging.service.metrics.types.user.TotalUsersMetric;

/**
 * Total Metric Factory
 */
public class TotalMetricFactory extends AbstractMetricFactory {

    /**
     * Create Users Metric
     */
    @Override
    public Metric createUsersMetric() {
        return new TotalUsersMetric();
    }

    /**
     * Create Messages Metric
     */
    @Override
    public Metric createMessagesMetric() {
        return new TotalMessagesMetric();
    }
}
