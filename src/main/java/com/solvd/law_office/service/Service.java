package com.solvd.law_office.service;

import com.solvd.law_office.agent.Client;
import com.solvd.law_office.agent.Lawyer;
import com.solvd.law_office.action.IAssignable;
import com.solvd.law_office.action.IOpenable;

public abstract class Service implements IAssignable, IOpenable<Service> {
    protected Lawyer lawyer;
    protected Client client;

    public Service() {
    }

    public Service(Client client) {
        this.client = client;
    }

    public Service(Lawyer lawyer, Client client) {
        this.lawyer = lawyer;
        this.client = client;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return this.client + "\n" + this.lawyer;
    }
}
