package com.solvd.lawoffice.functionalInterface;

@FunctionalInterface
public interface Consumer<T> {
    void accept (T t);
}
