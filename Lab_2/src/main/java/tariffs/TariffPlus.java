package tariffs;

/**  The class is enhanced tariffs of the mobile network with properties
 * <b>subscriptionFee</b>, <b>costMinuteInNW</b>, <b>costMinuteInOtherNW</b>,
 * <b>costSms</b>, <b>costInternet</b>, <b>species</b>,
 * <b>packageMinute</b>, and <b>packageInternet</b>.
 * @author Dzmitry Sokolenko
 * @version 1.0
 * @since 1.0
 * @see Tariff
 */

public class TariffPlus extends Tariff {
    private int packageMinute;
    private int packageInternet;

    public TariffPlus() {
        super();
    }

    public TariffPlus(int subscriptionFee, int costMinuteInNW, int costMinuteInOtherNW,
                      int costSms, int costInternet, Species species, int packageInternet, int packageMinute) {
        super(subscriptionFee, costMinuteInNW, costMinuteInOtherNW, costSms, costInternet, species);

        this.packageInternet = packageInternet;
        this.packageMinute = packageMinute;
    }

    @Override
    public String toString() {
        return super.toString() + "\n[Bonus: Package minute = " + packageMinute +
                ", PackageInternet = " + packageInternet + "]";
    }
}
