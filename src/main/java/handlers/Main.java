package handlers;

import collections.OfficeClients;
import collections.OfficeLawyers;
import collections.TicketsQueue;
import exceptions.InvalidAreaException;
import exceptions.InvalidServiceException;
import services.Counseling;
import services.Protection;
import services.Succession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    //Logger
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static final OfficeLawyers LAWYERS = new OfficeLawyers();

    public static void main(String[] args) {
        int option = 0;
        Ticket ticket;
        OfficeClients clients = new OfficeClients();
        TicketsQueue queue = new TicketsQueue();

        //Welcome message
        System.out.println("Welcome to Law office \n");

        //Service selection
        Menu.services();
        try {
            option = Menu.selectService();
        } catch (InvalidServiceException e) {
            LOGGER.warn(e.getMessage());
        }


        switch (option) {
            case 1:
                //Capture option
                Menu.area();
                try {
                    option = Menu.selectArea();
                } catch (InvalidAreaException e) {
                    LOGGER.warn(e.getMessage());
                }

                //Service creation
                Counseling counseling = new Counseling().openCase(option);
                //Add client to clients list
                clients.addClient(counseling.getClient());
                //Ticket creation
                ticket = new Ticket(counseling);
                //Add ticket to queue
                queue.addTicket(ticket);
                //Add ticket to client active tickets
                clients.getClientById(counseling.getClient().getClientId()).addTicket(ticket);;
                //Print ticket
                ticket.print();
                break;

            case 2:
                //Capture option
                Menu.area();
                //Capture option
                Menu.area();
                try {
                    option = Menu.selectArea();
                } catch (InvalidAreaException e) {
                    LOGGER.warn(e.getMessage());
                }

                //Service creation
                Protection protection = new Protection().openCase(option);
                //Add client to clients list
                clients.addClient(protection.getClient());
                //Ticket creation
                ticket = new Ticket(protection);
                //Add ticket to client active tickets
                clients.getClientById(protection.getClient().getClientId()).addTicket(ticket);;
                //Add ticket to queue
                queue.addTicket(ticket);
                //Print ticket
                ticket.print();
                break;

            case 3:
                //Service creation
                Succession succession = new Succession().openCase(option);
                //Add client to clients list
                clients.addClient(succession.getClient());
                //Ticket creation
                ticket = new Ticket(succession);
                //Add ticket to client active tickets
                clients.getClientById(succession.getClient().getClientId()).addTicket(ticket);
                //Add ticket to queue
                queue.addTicket(ticket);
                //Print ticket
                ticket.print();
                break;
        }


    }
}

