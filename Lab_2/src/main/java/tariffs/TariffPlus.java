package tariffs;

/**
 * The class is enhanced tariffs of the mobile network with properties
 * <b>subscriptionFee</b>, <b>costMinuteInNW</b>, <b>costMinuteInOtherNW</b>,
 * <b>costSms</b>, <b>costInternet</b>, <b>species</b>,
 * <b>packageMinute</b>, and <b>packageInternet</b>.
 *
 * @author Dzmitry Sokolenko
 * @version 1.0
 * @see Tariff
 * @since 1.0
 */
public class TariffPlus extends Tariff {
    /**
     * Property - tariff minutes plan package.
     */
    private int packageMinute;
    /**
     * Property - Internet tariff plan package.
     */
    private int packageInternet;

    /**
     * Constructor - creates a new object without the specified value.
     *
     * @see TariffPlus#TariffPlus(int, int, int, int, int, Species, int, int)
     */
    public TariffPlus() {
        super();
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
     * @param packageInternet     - Internet tariff plan package.
     * @param packageMinute       - tariff minutes plan package.
     * @see TariffPlus#TariffPlus()
     */
    public TariffPlus(int subscriptionFee,
                      int costMinuteInNW,
                      int costMinuteInOtherNW,
                      int costSms,
                      int costInternet,
                      Species species,
                      int packageInternet,
                      int packageMinute) {
        super(subscriptionFee, costMinuteInNW, costMinuteInOtherNW, costSms, costInternet, species);
        this.packageInternet = packageInternet;
        this.packageMinute = packageMinute;
    }

    /**
     * <p>A function display information about class-based
     * subscriptionFee, costMinuteInNW, costMinuteInOtherNW,
     * costSms, costInternet, and species properties</p>
     * <p>When creating a string of information, calls {@link Tariff#toString()}</p>
     *
     * @return Returns information about an {@link TariffPlus} object in String format.
     */
    @Override
    public String toString() {
        return super.toString() + "\n[Bonus: Package minute = " + packageMinute +
                ", PackageInternet = " + packageInternet + "]";
    }
}
