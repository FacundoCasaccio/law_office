package com.solvd.law_office.interfaces;

import com.solvd.law_office.exceptions.InvalidValueException;

public interface IUpdateable<T> {

    T update() throws InvalidValueException;
}
