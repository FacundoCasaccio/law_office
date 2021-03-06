package com.solvd.lawoffice.agent;

import com.solvd.lawoffice.officestandard.DaysOfTheWeek;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Lawyer extends Person {
    private int enrollment;
    private String speciality;
    private DaysOfTheWeek availability;
    private static final Logger LOGGER = LogManager.getLogger(Lawyer.class);

    public Lawyer() {
    }

    public Lawyer(String name, String surname, int personalId, int enrollment, String speciality, DaysOfTheWeek availability) {
        super(name, surname, personalId);
        this.enrollment = enrollment;
        this.speciality = speciality;
        this.availability = availability;
    }

    public int getEnrollment() {
        return this.enrollment;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public DaysOfTheWeek getAvailability() {
        return availability;
    }

    public void setAvailability(DaysOfTheWeek availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Lawyer: " + super.toString() + "\nEnrollment: " +
                this.enrollment + ", speciality: " + this.speciality +
                "Available: " + this.availability + "\n";
    }

    @Override
    public Lawyer update() {
        try (Scanner input = new Scanner(System.in)) {

            LOGGER.info("Enter claimant lawyer name: ");
            this.setName(input.nextLine());
            LOGGER.info("Enter claimant lawyer surname: ");
            this.setSurname(input.nextLine());
            LOGGER.info("Enter claimant lawyer speciality: ");
            this.setSpeciality(input.nextLine());
            LOGGER.info("Enter claimant lawyer enrollment: ");
            this.setEnrollment(input.nextInt());
            this.setAvailability(DaysOfTheWeek.MONDAY);
            input.nextLine();//Consume line
        }
        System.out.println();

        return this;
    }


}
