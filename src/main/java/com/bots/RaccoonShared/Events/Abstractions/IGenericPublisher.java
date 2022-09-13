package com.bots.RaccoonShared.Events.Abstractions;

public interface IGenericPublisher<L> {
    void subscribe(L subscriber);
    void unsubscribe(L subscriber);
}
