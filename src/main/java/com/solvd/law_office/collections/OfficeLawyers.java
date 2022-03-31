package com.solvd.law_office.collections;

import com.solvd.law_office.agents.Lawyer;

import java.util.ArrayList;
import java.util.List;

public class OfficeLawyers {
    private final List<Lawyer> lawyers = new ArrayList<>();

    public OfficeLawyers() {
        this.lawyers.add(new Lawyer("John", "Wick", 32453876, 333666, "criminal"));
        this.lawyers.add(new Lawyer("Jim", "Carrey", 22200222, 220022, "labor"));
        this.lawyers.add(new Lawyer("Homer", "Simpson", 64209, 64209, "family"));
        this.lawyers.add(new Lawyer("Steve", "Jobs", 99999999, 123789, "corporate"));
        this.lawyers.add(new Lawyer("Steve", "Grant Rogers", 77398712, 127835, "civil"));
        this.lawyers.add(new Lawyer("Jeff", "Bezos", 90777111, 777777, "business"));
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public Lawyer getLawyerByOption(int option) {
        return this.lawyers.get(option - 1);
    }
}