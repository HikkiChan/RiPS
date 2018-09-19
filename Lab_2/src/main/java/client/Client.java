package client;

import tariffs.Tariff;

public class Client {
    private String clientName;
    private String clientNumber;
    private Tariff.Species species;

    public Client(String clientName, String clientNumber, Tariff.Species species){
        this.clientName = clientName;
        this.clientNumber = clientNumber;
        this.species = species;
    }

    @Override
    public String toString() {
        return "Client Name: " + clientName + ", PhoneNumbers: " + clientNumber + ", Tariff plan: " + species ;
    }
}
