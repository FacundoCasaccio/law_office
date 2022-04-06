package com.solvd.lawoffice.handler;

import com.solvd.lawoffice.agent.Lawyer;
import com.solvd.lawoffice.collection.OfficeClients;
import com.solvd.lawoffice.collection.OfficeLawyers;
import com.solvd.lawoffice.collection.TicketsQueue;
import com.solvd.lawoffice.exception.InvalidAreaException;
import com.solvd.lawoffice.exception.InvalidServiceException;
import com.solvd.lawoffice.officestandard.SpecializedLawyers;
import com.solvd.lawoffice.service.Counseling;
import com.solvd.lawoffice.service.Protection;
import com.solvd.lawoffice.service.Succession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    //Logger
    public static final Logger LOGGER = LogManager.getLogger(Main.class);
    //Office lawyers
    public static OfficeLawyers LAWYERS = new OfficeLawyers();

    public static void main(String[] args) {
        //Adding lawyers for testing
        LAWYERS.addLawyer(SpecializedLawyers.CRIMINAL_LAWYER.getLawyer());
        LAWYERS.addLawyer(SpecializedLawyers.LABOR_LAWYER.getLawyer());
        LAWYERS.addLawyer(SpecializedLawyers.FAMILY_LAWYER.getLawyer());
        LAWYERS.addLawyer(SpecializedLawyers.CORPORATE_LAWYER.getLawyer());
        LAWYERS.addLawyer(SpecializedLawyers.CIVIL_LAWYER.getLawyer());
        LAWYERS.addLawyer(SpecializedLawyers.BUSINESS_LAWYER.getLawyer());

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
                clients.getClientById(counseling.getClient().getClientId()).addTicket(ticket);
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
                clients.getClientById(protection.getClient().getClientId()).addTicket(ticket);
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

