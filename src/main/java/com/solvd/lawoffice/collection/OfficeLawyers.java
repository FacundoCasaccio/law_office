package com.solvd.lawoffice.collection;

import com.solvd.lawoffice.agent.Lawyer;
import com.solvd.lawoffice.officestandard.DaysOfTheWeek;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class OfficeLawyers {
    private final List<Lawyer> lawyers = new ArrayList<>();

    public OfficeLawyers() {
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void addLawyer(Lawyer lawyer) {
        this.lawyers.add(lawyer);
    }

    public Lawyer getLawyerByOption(int option) {
        return this.lawyers.get(option - 1);
    }

    public void listLawyers(OfficeLawyers lawyers, DaysOfTheWeek day, BiFunction<List<Lawyer>, DaysOfTheWeek, List<Lawyer>> lawyersByDay) {

    }
}