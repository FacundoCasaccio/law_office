package com.solvd.law_office.handler;

import com.solvd.law_office.action.IPrintable;
import com.solvd.law_office.agent.Client;
import com.solvd.law_office.service.Counseling;
import com.solvd.law_office.service.Protection;
import com.solvd.law_office.service.Service;
import com.solvd.law_office.service.Succession;

public class Ticket implements IPrintable {
    private Service service;
    private double budget;
    private int ticketId;
    private static int ticketIdCounter;

    public Ticket() {
        ticketIdCounter++;
    }

    //Counseling ticket constructor
    public Ticket(Counseling counseling) {
        this.ticketId = ++Ticket.ticketIdCounter;
        this.service = counseling;
        this.budget = counseling.calculateBudget();
    }

    //Protection ticket constructor
    public Ticket(Protection protection) {
        this.ticketId = ++Ticket.ticketIdCounter;
        this.service = protection;
        this.budget = protection.calculateBudget();
    }

    //Succession ticket constructor
    public Ticket(Succession succession) {
        this.ticketId = ++Ticket.ticketIdCounter;
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
        return this.ticketId;
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
