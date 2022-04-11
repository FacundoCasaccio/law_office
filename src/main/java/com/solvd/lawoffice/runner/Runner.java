package com.solvd.lawoffice.runner;

import com.solvd.lawoffice.agent.*;
import com.solvd.lawoffice.collection.OfficeClients;
import com.solvd.lawoffice.collection.OfficeLawyers;
import com.solvd.lawoffice.collection.TicketsQueue;
import com.solvd.lawoffice.officestandard.DaysOfTheWeek;
import com.solvd.lawoffice.officestandard.Specialities;
import com.solvd.lawoffice.officestandard.SpecializedLawyers;
import com.solvd.lawoffice.handler.Ticket;
import com.solvd.lawoffice.service.Counseling;
import com.solvd.lawoffice.service.Protection;
import com.solvd.lawoffice.service.Succession;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Runner {

    //Logger
    public static final Logger LOGGER = LogManager.getLogger();
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
                "civil",
                DaysOfTheWeek.MONDAY);
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
