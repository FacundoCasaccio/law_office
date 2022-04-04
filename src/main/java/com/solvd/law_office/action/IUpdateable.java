package com.solvd.law_office.action;

import com.solvd.law_office.exception.InvalidValueException;

public interface IUpdateable<T> {

    T update() throws InvalidValueException;
}
