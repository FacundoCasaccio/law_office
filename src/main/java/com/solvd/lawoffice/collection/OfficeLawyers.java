package com.solvd.lawoffice.collection;

import com.solvd.lawoffice.agent.Lawyer;

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