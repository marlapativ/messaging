package edu.northeastern.messaging.service.metrics.types;

import edu.northeastern.messaging.service.metrics.Metric;
import edu.northeastern.messaging.service.metrics.types.message.CurrentSessionMessagesMetric;
import edu.northeastern.messaging.service.metrics.types.user.CurrentSessionUsersMetric;

public class CurrentSessionMetricFactory extends AbstractMetricFactory {

    @Override
    public Metric createUsersMetric() {
        return new CurrentSessionUsersMetric();
    }

    @Override
    public Metric createMessagesMetric() {
        return new CurrentSessionMessagesMetric();
    }

}
