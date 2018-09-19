package tariffs;

/**
 * The class is tariffs of the mobile network with properties
 * <b>subscriptionFee</b>, <b>costMinuteInNW</b>, <b>costMinuteInOtherNW</b>,
 * <b>costSms</b>, <b>costInternet</b>, and <b>species</b>.
 *
 * @author Dzmitry Sokolenko
 * @version 1.0
 * @see TariffPlus
 * @since 1.0
 */
public class Tariff {

    public enum Species {SMART, LITE, MAXIMUM}

    /**
     * Property - mobile tariff subscription fee.
     */
    private int subscriptionFee;
    /**
     * Property - cost per minute in the mobile operator network.
     */
    private int costMinuteInNW;
    /**
     * Property - cost per minute in the network of another mobile operator.
     */
    private int costMinuteInOtherNW;
    /**
     * Property - cost of one sms message.
     */
    private int costSms;
    /**
     * Property - the cost of one megabyte of Internet traffic.
     */
    private int costInternet;
    /**
     * Property - type of mobile tariffs.
     */
    private Species species;

    /**
     * Constructor - creates a new object without the specified value.
     *
     * @see Tariff#Tariff(int, int, int, int, int, Species)
     */
    Tariff() {
    }

    /**
     * Constructor - creates a new object with the specified value.
     *
     * @param subscriptionFee     - mobile tariff subscription fee.
     * @param costMinuteInNW      - cost per minute in the mobile operator network.
     * @param costMinuteInOtherNW - cost per minute in the network of another mobile operator.
     * @param costSms             - cost of one sms message.
     * @param costInternet        - the cost of one megabyte of Internet traffic.
     * @param species             - type of mobile tariffs.
     * @see Tariff#Tariff()
     */
    Tariff(int subscriptionFee,
           int costMinuteInNW,
           int costMinuteInOtherNW,
           int costSms,
           int costInternet,
           Species species) {
        this.subscriptionFee = subscriptionFee;
        this.costMinuteInNW = costMinuteInNW;
        this.costMinuteInOtherNW = costMinuteInOtherNW;
        this.costSms = costSms;
        this.costInternet = costInternet;
        this.species = species;
    }

    /**
     * Get-method for costMinuteInNW.
     *
     * @return Return cost per minute in the mobile operator network.
     */
    public int getCostMinuteInNW() {
        return costMinuteInNW;
    }

    /**
     * Get-method for species.
     *
     * @return Return type of mobile tariffs.
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * <p>A function display information about class-based
     * subscriptionFee, costMinuteInNW, costMinuteInOtherNW,
     * costSms, costInternet, and species properties</p>
     *
     * @return Returns information about an {@link Tariff} object in String format.
     */
    @Override
    public String toString() {
        return "Cost subscription fee = " + subscriptionFee
                + ", Cost minute in NW = " + costMinuteInNW
                + ", Cost minute in other NW = " + costMinuteInOtherNW
                + ", Cost sms = " + costSms
                + ", Cost internet traffic = " + costInternet
                + ", Tariff plan = " + species;
    }
}
