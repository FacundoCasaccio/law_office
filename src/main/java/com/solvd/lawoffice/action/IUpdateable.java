package com.solvd.lawoffice.action;

import com.solvd.lawoffice.exception.InvalidValueException;

public interface IUpdateable<T> {

    T update() throws InvalidValueException;
}
