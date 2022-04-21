package com.solvd.lawoffice.collection;

import com.solvd.lawoffice.handler.Ticket;
import com.solvd.lawoffice.action.IPrintable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

public class TicketsQueue implements IPrintable {
    private Queue<Ticket> queue = new LinkedList<>();
    private static final Logger LOGGER = LogManager.getLogger(TicketsQueue.class);

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
        LOGGER.info(this.queue);
    }
}
