package interfaces;

import exceptions.InvalidValueException;

public interface IUpdateable<T> {

    T update() throws InvalidValueException;
}
