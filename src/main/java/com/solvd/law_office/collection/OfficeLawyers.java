package com.solvd.law_office.collection;

import com.solvd.law_office.agent.Lawyer;

import java.util.ArrayList;
import java.util.List;

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
}