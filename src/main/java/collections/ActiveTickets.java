package collections;

import handlers.Ticket;
import interfaces.IPrintable;

public class ActiveTickets implements IPrintable {
    private TicketNode head;

    public void insert(Ticket ticket) {
        TicketNode newTicket = new TicketNode(ticket);
        if (this.head == null) {
            this.head = newTicket;
        } else {
            TicketNode currentTicket = this.head;
            //Get the last element of the list
            while(currentTicket.getNextTicket() != null) {
                currentTicket = currentTicket.getNextTicket();
            }
            //Assign next ticket to last element as new element
            currentTicket.setNextTicket(newTicket);
        }
    }

    public void insertUrgent(Ticket ticket) {
        TicketNode ticketNode = new TicketNode(ticket);

        //Swap places with head
        ticketNode.setNextTicket(this.head);
        this.head = ticketNode;
    }

    public void insertWithPriority(int index, Ticket ticket) {
        if (index == 0) {
            insertUrgent(ticket);
        } else {
            TicketNode newTicket = new TicketNode(ticket);
            TicketNode currentTicket = this.head;

            //Search for node previous to index
            for(int i = 0; i < (index - 1); i++) {
                currentTicket = currentTicket.getNextTicket();
            }
            //Assign ticket at index to the new ticket as next
            newTicket.setNextTicket(currentTicket.getNextTicket());
            //Assign ticket at index -1 next ticket as newTicket
            currentTicket.setNextTicket(newTicket);
        }
    }

    public void deleteAtPosition(int index) {
        if (index == 0) {
            this.head = this.head.getNextTicket();
        } else {
            TicketNode currentTicket = this.head;

            //Search for node previous to index
            for(int i = 0; i < (index - 1); i++) {
                currentTicket = currentTicket.getNextTicket();
            }
            //Assign next ticket as the ticket next to the ticket at index position
            currentTicket.setNextTicket(currentTicket.getNextTicket().getNextTicket());
        }
    }

    @Override
    public void print() {
        TicketNode currentTicket = this.head;

        //Empty list case
        if(currentTicket == null) {
            System.out.println("There are no active tickets");
        } else {
            while (currentTicket != null) {
                System.out.println(currentTicket.getTicket());
                currentTicket = currentTicket.getNextTicket();
            }
        }
    }
}
