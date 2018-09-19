package builder;

import tariffs.Tariff;
import tariffs.TariffPlus;

/**
 * The class of tariff plan design with properties of {@link tariffs.TariffPlus} class.
 *
 * @author Dzmitry Sokolenko
 * @version 1.0
 * @since 1.0
 */
public class TariffPlusBuilder {
    /**
     * Get-method for registration of the tariff plan "TariffPlus"
     *
     * @param subscriptionFee     - mobile tariff subscription fee.
     * @param costMinuteInNW      - cost per minute in the mobile operator network.
     * @param costMinuteInOtherNW - cost per minute in the network of another mobile operator.
     * @param costSms             - cost of one sms message.
     * @param costInternet        - the cost of one megabyte of Internet traffic.
     * @param species             - type of mobile tariffs.
     * @param packageInternet     - Internet tariff plan package.
     * @param packageMinute       - tariff minutes plan package.
     * @return Returns an object of class {@link tariffs.TariffPlus}
     */
    public static TariffPlus getTariffPlus(int subscriptionFee,
                                           int costMinuteInNW,
                                           int costMinuteInOtherNW,
                                           int costSms,
                                           int costInternet,
                                           Tariff.Species species,
                                           int packageInternet,
                                           int packageMinute) {
        TariffPlus tariffPlus = new TariffPlus();

        switch (species) {
            case SMART:
                Smart builderSmart = new Smart();
                tariffPlus = builderSmart.getTariffPlus(subscriptionFee, costMinuteInNW, costMinuteInOtherNW,
                        costSms, costInternet, packageInternet, packageMinute);
                break;
            case LITE:
                Lite builderLite = new Lite();
                tariffPlus = builderLite.getTariffPlus(subscriptionFee, costMinuteInNW, costMinuteInOtherNW,
                        costSms, costInternet, packageInternet, packageMinute);
                break;
            case MAXIMUM:
                Maximum builderAbsolute = new Maximum();
                tariffPlus = builderAbsolute.getTariffPlus(subscriptionFee, costMinuteInNW, costMinuteInOtherNW,
                        costSms, costInternet, packageInternet, packageMinute);
                break;
        }

        return tariffPlus;
    }
}
