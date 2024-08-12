package edu.northeastern.messaging.service.metrics.types;

import edu.northeastern.messaging.service.metrics.Metric;
import edu.northeastern.messaging.service.metrics.types.message.CurrentSessionMessagesMetric;
import edu.northeastern.messaging.service.metrics.types.user.CurrentSessionUsersMetric;

/**
 * Current Session Metric Factory
 */
public class CurrentSessionMetricFactory extends AbstractMetricFactory {

    /**
     * Create Users Metric
     */
    @Override
    public Metric createUsersMetric() {
        return new CurrentSessionUsersMetric();
    }

    /**
     * Create Messages Metric
     */
    @Override
    public Metric createMessagesMetric() {
        return new CurrentSessionMessagesMetric();
    }

}
