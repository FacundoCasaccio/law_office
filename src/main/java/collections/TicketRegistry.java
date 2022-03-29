package collections;

import handlers.Ticket;
import interfaces.IPrintable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TicketRegistry implements IPrintable {
    private Set<Ticket> registry = new HashSet<>();

    public TicketRegistry(){}

    public void setRegistry(Set<Ticket> registry) {
        this.registry = registry;
    }

    public Set<Ticket> getRegistry() {
        return registry;
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(this.registry.toArray()));
    }
}
