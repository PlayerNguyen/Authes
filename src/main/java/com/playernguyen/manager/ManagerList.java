package com.playernguyen.manager;

import java.util.*;

public class ManagerList<T> implements Manager<T> {

    private final List<T> container;
    public ManagerList() {
        this.container = new ArrayList<>();
    }

    @Override
    public List<T> getContainer() {
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
