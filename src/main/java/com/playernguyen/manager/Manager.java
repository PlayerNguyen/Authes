package com.playernguyen.manager;

import java.util.Collection;

/**
 * An immutable set to make that true
 */
public interface Manager<T> extends Iterable<T>{

    Collection<T> getContainer();

    void add(T item);

}
