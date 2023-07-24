package model.dao;

import model.entity.Client;

public interface ClientDAO {
    void createClient(Client client);
    Client getClientByDni(int dni);
}
