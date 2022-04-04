package com.solvd.lawoffice.service;

import com.solvd.lawoffice.agent.Client;
import com.solvd.lawoffice.agent.Lawyer;
import com.solvd.lawoffice.action.IAssignable;
import com.solvd.lawoffice.action.IOpenable;

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
