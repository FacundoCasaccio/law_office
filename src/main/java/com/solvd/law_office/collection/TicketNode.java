package com.solvd.law_office.collection;

import com.solvd.law_office.handler.Ticket;

public class TicketNode {
    private Ticket ticket;
    private TicketNode nextTicket;

    public TicketNode() {
    }

    public TicketNode(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public TicketNode getNextTicket() {
        return nextTicket;
    }

    public void setNextTicket(TicketNode nextTicket) {
        this.nextTicket = nextTicket;
    }
}
