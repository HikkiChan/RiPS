package builder;

import tariffs.Tariff;
import tariffs.TariffPlus;

/**
 * The class for registration of the tariff plan "Smart".
 *
 * @author Dzmitry Sokolenko
 * @version 1.0
 * @see Tariff
 * @since 1.0
 */
public class Smart implements Builder {
    /**
     * Get-method for registration of the tariff plan "Smart"
     *
     * @param subscriptionFee     - mobile tariff subscription fee.
     * @param costMinuteInNW      - cost per minute in the mobile operator network.
     * @param costMinuteInOtherNW - cost per minute in the network of another mobile operator.
     * @param costSms             - cost of one sms message.
     * @param costInternet        - the cost of one megabyte of Internet traffic.
     * @param packageInternet     - Internet tariff plan package.
     * @param packageMinute       - tariff minutes plan package.
     * @return Returns an object of class {@link tariffs.TariffPlus}
     */
    @Override
    public TariffPlus getTariffPlus(int subscriptionFee,
                                    int costMinuteInNW,
                                    int costMinuteInOtherNW,
                                    int costSms,
                                    int costInternet,
                                    int packageInternet,
                                    int packageMinute) {
        return new TariffPlus(
                subscriptionFee,
                costMinuteInNW,
                costMinuteInOtherNW,
                costSms,
                costInternet,
                Tariff.Species.SMART,
                packageInternet,
                packageMinute);
    }
}
