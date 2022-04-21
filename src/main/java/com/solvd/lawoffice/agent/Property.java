package com.solvd.lawoffice.agent;

import com.solvd.lawoffice.exception.InvalidValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class Property extends Asset {
    private Address address;
    private double dimension;
    private static final Logger LOGGER = LogManager.getLogger(Property.class);

    public Property() {
    }

    public Property(double value, ThirdParty owner, Address address, double dimension) {
        super(value, owner);
        this.address = address;
        this.dimension = dimension;
    }

    public Address getAddress() {
        return this.address;
    }

    public double getDimension() {
        return this.dimension;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return "Property: \n" + super.toString() + ", dimension: " +
                this.dimension + "m2\nProperty " +
                this.address;
    }

    @Override
    public Property update() throws InvalidValueException {
        try (Scanner input = new Scanner(System.in)) {

            //Property owner
            LOGGER.info("Property owner data: \n");
            this.owner = new ThirdParty().update();

            //Property data
            LOGGER.info("Enter property's value: ");
            this.setValue(parseDouble((input.nextLine())));
            if (this.value < 0) {
                throw new InvalidValueException("Value cannot be negative");
            }

            LOGGER.info("Enter property's dimension: ");
            this.setDimension(input.nextInt());
            if (this.dimension <= 0) {
                throw new InvalidValueException("Dimension cannot be 0 or less");
            }
            input.nextLine(); //Consume line
        }

        //Property address update
        LOGGER.info("\nEnter property's address: ");
        this.address = new Address().update();

        return this;
    }
}
