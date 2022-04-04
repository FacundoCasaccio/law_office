package com.solvd.lawoffice.agent;

import com.solvd.lawoffice.action.IUpdateable;

public abstract class Person implements IUpdateable<Person> {
    protected String name;
    protected String surname;
    protected int personalId;

    protected Person(String name, String surname, int personalId) {
        this.name = name;
        this.surname = surname;
        this.personalId = personalId;
    }

    protected Person() {
    }

    public String getName() {
        return this.name;
    }

    public int getIdNumber() {
        return this.personalId;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPersonalId(int idNumber) {
        this.personalId = idNumber;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return this.name + " " +
                this.surname + ", ID: " +
                this.personalId;
    }
}
