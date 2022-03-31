package com.solvd.law_office.agents;

import java.util.Scanner;

public class Lawyer extends Person {
    private int enrollment;
    private String speciality;

    public Lawyer() {
    }

    public Lawyer(String name, String surname, int personalId, int enrollment, String speciality) {
        super(name, surname, personalId);
        this.enrollment = enrollment;
        this.speciality = speciality;
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

    @Override
    public String toString() {
        return "Lawyer: " + super.toString() + "\nEnrollment: " +
                this.enrollment + ", speciality: " + this.speciality + "\n";
    }

    @Override
    public Lawyer update() {
        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter claimant lawyer name: ");
            this.setName(input.nextLine());
            System.out.print("Enter claimant lawyer surname: ");
            this.setSurname(input.nextLine());
            System.out.print("Enter claimant lawyer speciality: ");
            this.setSpeciality(input.nextLine());
            System.out.print("Enter claimant lawyer enrollment: ");
            this.setEnrollment(input.nextInt());
            input.nextLine();//Consume line
        }
        System.out.println();

        return this;
    }
}
