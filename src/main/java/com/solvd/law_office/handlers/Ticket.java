package com.solvd.law_office.handlers;

import com.solvd.law_office.interfaces.IPrintable;
import com.solvd.law_office.services.Counseling;
import com.solvd.law_office.services.Protection;
import com.solvd.law_office.services.Service;
import com.solvd.law_office.services.Succession;

public class Ticket implements IPrintable {
    private Service service;
    private double budget;
    private static int ticketId;

    public Ticket() {
        ticketId++;
    }

    //Counseling ticket constructor
    public Ticket(Counseling counseling) {
        ticketId++;
        this.service = counseling;
        this.budget = counseling.calculateBudget();
    }

    //Protection ticket constructor
    public Ticket(Protection protection) {
        ticketId++;
        this.service = protection;
        this.budget = protection.calculateBudget();
    }

    //Succession ticket constructor
    public Ticket(Succession succession) {
        ticketId++;
        this.service = succession;
        this.budget = succession.calculateBudget();
    }

    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public double getBudget() {
        return this.budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void displayTicket() {
        System.out.println();
    }

    @Override
    public String toString() {
        return "\n\nTicket " + ticketId + "\n" +
                this.service + "\n\n" +
                "Budget: $" + this.budget;
    }

    @Override
    public void print() {
        System.out.println((this));
    }
}
