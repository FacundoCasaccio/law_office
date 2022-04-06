package com.solvd.lawoffice.functionalInterface;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
