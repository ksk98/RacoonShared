package com.bots.RaccoonShared.Events.Abstractions;

import java.util.LinkedList;
import java.util.List;

public abstract class GenericPublisher<L> implements IGenericPublisher<L> {
    protected final List<L> subscribers;

    public GenericPublisher() {
        this.subscribers = new LinkedList<>();
    }

    public void subscribe(L subscriber) {
        if (!subscribers.contains(subscriber))
            subscribers.add(subscriber);
    }

    public void unsubscribe(L subscriber) {
        subscribers.remove(subscriber);
    }
}
