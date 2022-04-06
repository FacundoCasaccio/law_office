package com.solvd.lawoffice.officestandard;

public enum Specialities {
    CRIMINAL("criminal"),
    LABOR("labor"),
    FAMILY("family"),
    CORPORATE("corporate"),
    CIVIL("civil"),
    BUSINESS("business");

    String speciality;

    Specialities (String speciality) {
        this.speciality = speciality;
    }
}
