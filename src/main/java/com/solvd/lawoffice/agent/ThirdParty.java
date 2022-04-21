package com.solvd.lawoffice.agent;

import com.solvd.lawoffice.exception.InvalidValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ThirdParty extends Person {
    private String role;
    private Address address;
    private static final Logger LOGGER = LogManager.getLogger(ThirdParty.class);

    public ThirdParty() {
    }

    public ThirdParty(String name, String surname, int personalId, String role, Address address) {
        super(name, surname, personalId);
        this.role = role;
        this.address = address;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return this.role + ": " +
                super.toString() + "\n" +
                "Address: " + this.address + "\n";
    }

    @Override
    public ThirdParty update() {
        try (Scanner input = new Scanner(System.in)) {

            //ThirdParty personal data
            LOGGER.info("Enter Third party name: ");
            this.setName(input.nextLine());
            LOGGER.info("Enter Third party surname: ");
            this.setSurname(input.nextLine());
            LOGGER.info("Enter Third party role: ");
            this.setRole(input.nextLine());
            LOGGER.info("Enter Third party Id number: ");
            this.setPersonalId(input.nextInt());
            input.nextLine(); //Consume line
        }

        //ThirdParty address update
        LOGGER.info("\nEnter Third party Address: ");
        try {
            this.address = new Address().update();
        } catch (InvalidValueException e) {
            LOGGER.warn(e.getMessage());
        }

        return this;
    }
}
