package com.solvd.lawoffice.service;

import com.solvd.lawoffice.agent.Client;
import com.solvd.lawoffice.agent.Lawyer;
import com.solvd.lawoffice.handler.Main;
import com.solvd.lawoffice.action.IBudgetable;
import com.solvd.lawoffice.exception.NoLawyerAvailableException;

public class Counseling extends Service implements IBudgetable {

    public Counseling() {
    }

    public Counseling(Lawyer lawyer, Client client) {
        super(lawyer, client);
    }

    public Counseling(Client client) {
        super(client);
    }


    @Override
    public double calculateBudget() {
        double budget;

        switch (this.lawyer.getSpeciality()) {
            case "labor":
                budget = 150;
                return budget;
            case "corporate":
                budget = 500;
                return budget;
            case "family":
                budget = 100;
                return budget;
            case "criminal":
                budget = 200;
                return budget;
            default:
                budget = 80;
                return budget;
        }
    }

    @Override
    public String toString() {
        return "Service: counseling \n" +
                super.toString();
    }

    @Override
    public Lawyer assignLawyer(int option) throws NoLawyerAvailableException {
        if (Main.LAWYERS.getLawyerByOption(option) == null){
            throw new NoLawyerAvailableException("There is no lawyer available");
        }
        return Main.LAWYERS.getLawyerByOption(option);
    }

    @Override
    public Counseling openCase(int option) {
        this.client = new Client().update();
        this.lawyer = assignLawyer(option);
        return this;
    }
}
