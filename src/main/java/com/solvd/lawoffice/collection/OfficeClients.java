package com.solvd.lawoffice.collection;

import com.solvd.lawoffice.agent.Client;
import com.solvd.lawoffice.action.IPrintable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class OfficeClients implements IPrintable {
    private HashMap<Integer, Client> clients = new HashMap<>();
    private static final Logger LOGGER = LogManager.getLogger(OfficeClients.class);

    public void addClient(Client client) {
        this.clients.put(client.getClientId(), client);
    }

    public void deleteClient(Client client) {
        this.clients.remove(client.getClientId());
    }

    public Client getClientById(Integer id) {
        return this.clients.get(id);
    }

    public HashMap<Integer, Client> getClients() {
        return this.clients;
    }

    @Override
    public void print() {
        LOGGER.info(clients);
    }
}
