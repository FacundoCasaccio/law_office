package com.solvd.lawoffice.agent;

import com.solvd.lawoffice.exception.InvalidValueException;
import com.solvd.lawoffice.action.IUpdateable;

import java.util.Scanner;

public class Address implements IUpdateable<Address> {
    private String country;
    private String state;
    private String city;
    private String street;
    private int number;

    public Address() {
    }

    public Address(String country, String state, String city, String street, int number) {
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address update() throws InvalidValueException {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Country: ");
            this.setCountry(input.nextLine());
            System.out.print("State: ");
            this.setState(input.nextLine());
            System.out.print("City: ");
            this.setCity(input.nextLine());
            System.out.print("Street: ");
            this.setStreet(input.nextLine());
            System.out.print("Number: ");
            this.setNumber(input.nextInt());
            if (this.number <= 0) {
                throw new InvalidValueException("Address number cannot be below 0");
            }
            input.nextLine(); //Consume line
        }
        System.out.println();

        return this;
    }

    @Override
    public String toString() {
        return "Address: " +
                this.street + " " +
                this.number + ", " +
                this.city + ", " +
                this.state + ", " +
                this.country;
    }
}
