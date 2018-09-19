package client;

import tariffs.Tariff;

/**
 * The class is clients of the mobile company with properties
 * <b>subscriptionFee</b>, <b>costMinuteInNW</b>, <b>costMinuteInOtherNW</b>,
 * <b>costSms</b>, <b>costInternet</b>, and <b>species</b>.
 *
 * @author Dzmitry Sokolenko
 * @version 1.0
 * @since 1.0
 */
public class Client {
    /**
     * Property - name of client.
     */
    private String clientName;
    /**
     * Property - client's mobile phone number.
     */
    private String clientNumber;
    /**
     * Property - type of mobile tariffs.
     */
    private Tariff.Species species;

    /**
     * Constructor - creates a new object with the specified value.
     *
     * @param clientName   - name of client.
     * @param clientNumber - client's mobile phone number.
     * @param species      - type of mobile tariffs.
     */
    public Client(String clientName, String clientNumber, Tariff.Species species) {
        this.clientName = clientName;
        this.clientNumber = clientNumber;
        this.species = species;
    }

    /**
     * <p>A function display information about class-based
     * clientName, clientNumber, and species properties</p>
     *
     * @return Returns information about an {@link Client} object in String format.
     */
    @Override
    public String toString() {
        return "Client Name: " + clientName
                + ", PhoneNumbers: " + clientNumber
                + ", Tariff plan: " + species;
    }
}
