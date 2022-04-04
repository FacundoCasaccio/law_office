package com.solvd.law_office.collection;

import com.solvd.law_office.handler.Ticket;
import com.solvd.law_office.action.IPrintable;

import java.util.LinkedList;
import java.util.Queue;

public class TicketsQueue implements IPrintable {
    private Queue<Ticket> queue = new LinkedList<>();

    public Queue<Ticket> getQueue() {
        return this.queue;
    }

    public void addTicket(Ticket ticket) {
        this.queue.add(ticket);
    }

    public Ticket getNextTicket() {
        return this.queue.poll();
    }

    @Override
    public void print() {
        System.out.println(this.queue);
    }
}
