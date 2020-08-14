package com.playernguyen.manager;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class ManagerSet<T> implements Manager<T> {
    private final Collection<T> container;
    public ManagerSet() {
        this.container = new HashSet<>();
    }

    @Override
    public Collection<T> getContainer() {
        return container;
    }

    @Override
    public void add(T item) {
        this.getContainer().add(item);
    }

    @Override
    public Iterator<T> iterator() {
        return getContainer().iterator();
    }
}
