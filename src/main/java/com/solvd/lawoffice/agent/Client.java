package com.solvd.lawoffice.agent;

import com.solvd.lawoffice.collection.ActiveTickets;
import com.solvd.lawoffice.collection.TicketRegistry;
import com.solvd.lawoffice.exception.InvalidValueException;
import com.solvd.lawoffice.handler.Ticket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Client extends Person {
    private static int clientIdCounter;
    private int clientId;
    private Address address;
    private ActiveTickets activeTickets = new ActiveTickets();
    private TicketRegistry ticketRegistry = new TicketRegistry();

    public Client(String name, String surname, int personalId, Address address) {
        super(name, surname, personalId);
        this.clientId = ++clientIdCounter;
        this.address = address;
    }

    public Client() {
        this.clientId = ++clientIdCounter;
    }

    public int getClientId() {
        return clientId;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client: " + super.toString() + "\n" + this.address + "\n";
    }

    @Override
    public Client update() {
        try (Scanner input = new Scanner(System.in)) {

            //Client personal data
            System.out.print("Enter client name: ");
            this.setName(input.nextLine());
            System.out.print("Enter client surname: ");
            this.setSurname(input.nextLine());
            System.out.print("Enter client Id number: ");
            this.setPersonalId(input.nextInt());
            input.nextLine(); //Consume line
            //Client address update
            System.out.println("\nEnter client Address: ");
            try {
                this.address = new Address().update();
            } catch (InvalidValueException e) {
                Logger logger = LogManager.getLogger(Client.class);
                logger.warn(e.getMessage());
            }
        }

        return this;
    }

    public ActiveTickets getActiveTickets() {
        return this.activeTickets;
    }

    public void showActiveTickets(){
        this.activeTickets.print();
    }

    public void addTicket(Ticket ticket) {
        this.activeTickets.insert(ticket);
    }

    public TicketRegistry getTicketRegistry() {
        return ticketRegistry;
    }

}
