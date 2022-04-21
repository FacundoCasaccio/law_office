package com.solvd.lawoffice.collection;

import com.solvd.lawoffice.handler.Ticket;
import com.solvd.lawoffice.action.IPrintable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TicketRegistry implements IPrintable {
    private Set<Ticket> registry = new HashSet<>();
    private static final Logger LOGGER = LogManager.getLogger(TicketRegistry.class);

    public TicketRegistry(){}

    public void setRegistry(Set<Ticket> registry) {
        this.registry = registry;
    }

    public Set<Ticket> getRegistry() {
        return registry;
    }

    @Override
    public void print() {
        LOGGER.info(Arrays.toString(this.registry.toArray()));
    }
}
