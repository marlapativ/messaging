package edu.northeastern.messaging.service.metrics.types;

import edu.northeastern.messaging.service.metrics.Metric;
import edu.northeastern.messaging.service.metrics.types.message.TotalMessagesMetric;
import edu.northeastern.messaging.service.metrics.types.user.TotalUsersMetric;

public class TotalMetricFactory extends AbstractMetricFactory {

    @Override
    public Metric createUsersMetric() {
        return new TotalUsersMetric();
    }

    @Override
    public Metric createMessagesMetric() {
        return new TotalMessagesMetric();
    }
}
