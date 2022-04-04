package com.solvd.law_office.runner;

import com.solvd.law_office.agent.*;
import com.solvd.law_office.collection.OfficeClients;
import com.solvd.law_office.collection.OfficeLawyers;
import com.solvd.law_office.collection.TicketsQueue;
import com.solvd.law_office.handler.Ticket;
import com.solvd.law_office.service.Counseling;
import com.solvd.law_office.service.Protection;
import com.solvd.law_office.service.Succession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    //Logger
    public static final Logger LOGGER = LogManager.getLogger();
    //Office lawyers
    public static OfficeLawyers LAWYERS = new OfficeLawyers();

    public static void main(String[] args) {
        //Adding lawyers for testing
        LAWYERS.addLawyer(new Lawyer("John", "Wick", 32453876, 333666, "criminal"));
        LAWYERS.addLawyer(new Lawyer("Jim", "Carrey", 22200222, 220022, "labor"));
        LAWYERS.addLawyer(new Lawyer("Homer", "Simpson", 64209, 64209, "family"));
        LAWYERS.addLawyer(new Lawyer("Steve", "Jobs", 99999999, 123789, "corporate"));
        LAWYERS.addLawyer(new Lawyer("Steve", "Grant Rogers", 77398712, 127835, "civil"));
        LAWYERS.addLawyer(new Lawyer("Jeff", "Bezos", 90777111, 777777, "business"));

        Client testClient = new Client(
                "Facundo",
                "Casaccio",
                39765756,
                new Address("Argentina", "Buenos Aires","Adrogué","Street",123));
        Lawyer claimantLawyer = new Lawyer(
                "Tony",
                "Stark",
                1234556,
                111222,
                "civil");
        Claimant testClaimant = new Claimant(
                "Horacio",
                "Guarani",
                34876590,
                new Address("Argentina", "Buenos Aires", "CABA", "Street", 456),
                claimantLawyer);
        ThirdParty witness = new ThirdParty(
                "Ash",
                "Ketchum",
                4456983,
                "Witness",
                new Address("Argentina", "Buenos Aires","Adrogué","Street",123));
        ThirdParty owner = new ThirdParty(
                "Mac",
                "Miller",
                4456782,
                "Owner",
                new Address("Argentina", "Buenos Aires","Adrogué","Street",123));
        Property property = new Property(
                220000,
                owner,
                new Address("Argentina", "Buenos Aires","Lanus","Street",234),
                97.3);
        TicketsQueue queue = new TicketsQueue();
        OfficeClients clients = new OfficeClients();

        //Adding client to the list
        clients.addClient(testClient);

        //Counseling ticket
        Counseling counseling = new Counseling(LAWYERS.getLawyerByOption(4), testClient);
        Ticket counselingTicket = new Ticket(counseling);
        testClient.addTicket(counselingTicket);
        queue.addTicket(counselingTicket); //Add ticket to the queue
        //counselingTicket.print();

        //Protection ticket
        Protection protection = new Protection(LAWYERS.getLawyerByOption(1),testClient,testClaimant,witness);
        Ticket protectionTicket = new Ticket(protection);
        testClient.addTicket(protectionTicket);
        queue.addTicket(protectionTicket); //Add ticket to the queue
        //protectionTicket.print();

        //Succession ticket
        Succession succession = new Succession(LAWYERS.getLawyerByOption(3),testClient,witness,property);
        Ticket successionTicket = new Ticket(succession);
        testClient.addTicket(successionTicket);
        queue.addTicket(successionTicket); //Add ticket to the queue
        //successionTicket.print();

        //testClient.showActiveTickets();
        //testClient.getActiveTickets().solveTicket(testClient,1); //Solve ticket

        //System.out.println("**********************************************");

        //testClient.showActiveTickets(); //Show updated active tickets
        //testClient.getTicketRegistry().print(); //Show ticket registry

        //queue.print();
        clients.print();
    }
}
