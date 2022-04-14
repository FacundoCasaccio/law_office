package com.solvd.lawoffice.runner;

import com.solvd.lawoffice.action.IList;
import com.solvd.lawoffice.action.IPrintable;
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
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        //Adding multiple clients for testing
        Client testClient2 = new Client(
                "William",
                "Casaccio",
                39765756,
                new Address("Argentina", "Buenos Aires","Adrogué","Street",123));
        Client testClient3 = new Client(
                "Pablo",
                "Casaccio",
                39765756,
                new Address("Argentina", "Buenos Aires","Adrogué","Street",123));
        Client testClient4 = new Client(
                "John",
                "Casaccio",
                39765756,
                new Address("Argentina", "Buenos Aires","Adrogué","Street",123));
        Client testClient5 = new Client(
                "Martin",
                "Casaccio",
                39765756,
                new Address("Argentina", "Buenos Aires","Adrogué","Street",123));
        Client testClient6 = new Client(
                "Erika",
                "Casaccio",
                39765756,
                new Address("Argentina", "Buenos Aires","Adrogué","Street",123));
        Client testClient7 = new Client(
                "Eva",
                "Casaccio",
                39765756,
                new Address("Argentina", "Buenos Aires","Adrogué","Street",123));
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
        OfficeClients officeClients = new OfficeClients();

        //Adding client to the list
        officeClients.addClient(testClient);
        officeClients.addClient(testClient2);
        officeClients.addClient(testClient3);
        officeClients.addClient(testClient4);
        officeClients.addClient(testClient5);
        officeClients.addClient(testClient6);
        officeClients.addClient(testClient7);


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
        //officeClients.print();

        //Get lawyers by availability on specific day
        //Using java provided functional interface
        BiFunction<List<Lawyer>, DaysOfTheWeek, List<Lawyer>> lawyersByDay =
                (lawyers, day) -> lawyers.stream()
                        .filter(lawyer -> lawyer.getAvailability() == day)
                        .collect(Collectors.toList());

        //Test for lawyers available on Monday
        System.out.println(lawyersByDay.apply(LAWYERS.getLawyers(), DaysOfTheWeek.MONDAY));

        //List lawyers alphabetically
        //Using java provided functional interface
        Function<List<Lawyer>, List<Lawyer>> listLawyersAlphabetically =
                (lawyers) -> lawyers.stream()
                        .sorted(Comparator.comparing(Person::getName))
                        .collect(Collectors.toList());

        System.out.println(listLawyersAlphabetically.apply(LAWYERS.getLawyers()));

        //List clients
        //IList clientList = (officeClients) ->

    }

    //public static void displayList(IPrintable list) {
        //list.print();
    //}

}
