package edu.northeastern.messaging.service.metrics.types.message;

import edu.northeastern.messaging.service.metrics.Metric;

/**
 * Current Session Messages Metric
 */
public class CurrentSessionMessagesMetric implements Metric {

    protected int messageCount;

    @Override
    public String getName() {
        return "Current Session Messages";
    }

    @Override
    public int getValue() {
        return messageCount;
    }

    @Override
    public void increment() {
        messageCount++;
    }

    @Override
    public void decrement() {
        messageCount--;
    }

    @Override
    public void updateMetric(Type metricType) {
        if (metricType == Type.MESSAGE_ADD) {
            increment();
        } else if (metricType == Type.MESSAGE_REMOVE) {
            decrement();
        }
    }
}
