package edu.northeastern.messaging.service.metrics.types.user;

import edu.northeastern.messaging.service.metrics.Metric;

public class CurrentSessionUsersMetric implements Metric {

    protected int userCount;

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public int getValue() {
        return userCount;
    }

    @Override
    public void increment() {
        this.userCount++;
    }

    @Override
    public void decrement() {
        this.userCount--;
    }

    @Override
    public void updateMetric(Type metricType) {
        if (metricType == Type.USER_ADD) {
            increment();
        } else if (metricType == Type.USER_REMOVE) {
            decrement();
        }
    }
}
