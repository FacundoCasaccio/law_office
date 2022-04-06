package com.solvd.lawoffice.officestandard;

import com.solvd.lawoffice.agent.Lawyer;

public enum SpecializedLawyers {
    CRIMINAL_LAWYER(new Lawyer("John", "Wick", 32453876, 333666, Specialities.CRIMINAL.speciality,DaysOfTheWeek.MONDAY)),
    LABOR_LAWYER(new Lawyer("Jim", "Carrey", 22200222, 220022, Specialities.LABOR.speciality,DaysOfTheWeek.THURSDAY)),
    FAMILY_LAWYER(new Lawyer("Homer", "Simpson", 64209, 64209, Specialities.FAMILY.speciality, DaysOfTheWeek.FRIDAY)),
    CORPORATE_LAWYER(new Lawyer("Steve", "Jobs", 99999999, 123789, Specialities.CORPORATE.speciality, DaysOfTheWeek.TUESDAY)),
    CIVIL_LAWYER(new Lawyer("Steve", "Grant Rogers", 77398712, 127835, Specialities.CIVIL.speciality, DaysOfTheWeek.MONDAY)),
    BUSINESS_LAWYER(new Lawyer("Jeff", "Bezos", 90777111, 777777, Specialities.BUSINESS.speciality, DaysOfTheWeek.TUESDAY));

    private final Lawyer lawyer;

    SpecializedLawyers(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }
}
