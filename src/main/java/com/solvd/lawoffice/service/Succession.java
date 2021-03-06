package com.solvd.lawoffice.service;

import com.solvd.lawoffice.agent.Client;
import com.solvd.lawoffice.agent.Lawyer;
import com.solvd.lawoffice.agent.Property;
import com.solvd.lawoffice.agent.ThirdParty;
import com.solvd.lawoffice.exception.InvalidValueException;
import com.solvd.lawoffice.handler.Main;
import com.solvd.lawoffice.action.IBudgetable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Succession extends Service implements IBudgetable {
    private ThirdParty thirdParty;
    private Property property;
    private final Logger LOGGER = LogManager.getLogger(Succession.class);

    public Succession() {
    }

    public Succession(Lawyer lawyer, Client client, ThirdParty thirdParty, Property property) {
        super(lawyer, client);
        this.thirdParty = thirdParty;
        this.property = property;
    }

    public ThirdParty getThirdParty() {
        return this.thirdParty;
    }

    public void setThirdParty(ThirdParty thirdParty) {
        this.thirdParty = thirdParty;
    }

    public Property getProperty() {
        return this.property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }


    @Override
    public double calculateBudget() {
        double budget;

        if (this.property.getDimension() < 30) {
            budget = this.property.getValue() * 0.05;
            return budget;
        }
        budget = this.property.getValue() * 0.08;
        return budget;
    }

    @Override
    public String toString() {
        return "Service: succession \n" +
                super.toString() + "\n" +
                this.thirdParty + "\n" +
                this.property;
    }

    @Override
    public Lawyer assignLawyer(int option) {
        return Main.LAWYERS.getLawyerByOption(option);
    }

    @Override
    public Succession openCase(int option) {
        this.client = new Client().update();
        this.lawyer = assignLawyer(option);
        this.thirdParty = new ThirdParty().update();
        try {
            this.property = new Property().update();
        } catch (InvalidValueException e) {
            LOGGER.warn(e.getMessage());
        }

        return this;
    }
}
