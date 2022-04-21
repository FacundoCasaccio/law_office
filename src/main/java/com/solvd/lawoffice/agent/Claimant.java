package com.solvd.lawoffice.agent;

import com.solvd.lawoffice.exception.InvalidValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Claimant extends Person {
    private Address address;
    private Lawyer lawyer;
    private static final Logger LOGGER = LogManager.getLogger(Claimant.class);

    public Claimant() {
    }

    public Claimant(String name, String surname, int personalId, Address address, Lawyer lawyer) {
        super(name, surname, personalId);

        this.address = address;
        this.lawyer = lawyer;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Lawyer getLawyer() {
        return this.lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    @Override
    public String toString() {
        return "Claimant: " + super.toString() + "\n" +
                this.address + "\n" +
                this.lawyer + "\n";
    }


    @Override
    public Claimant update() {
        try (Scanner input = new Scanner(System.in)) {

            //Claimant personal data
            LOGGER.info("Enter claimant name: ");
            this.setName(input.nextLine());
            LOGGER.info("Enter claimant surname: ");
            this.setSurname(input.nextLine());
            LOGGER.info("Enter claimant Id number: ");
            this.setPersonalId(input.nextInt());
            input.nextLine(); //Consume line
        }

        //Claimant address update
        LOGGER.info("\nEnter claimant Address: ");
        try {
            this.address = new Address().update();
        } catch (InvalidValueException e) {
            LOGGER.warn(e.getMessage());
        }

        //Claimant lawyer update
        this.lawyer = new Lawyer().update();

        return this;
    }
}
