package builder;

import tariffs.Tariff;
import tariffs.TariffPlus;

public class Maximum implements Builder {
    @Override
    public TariffPlus getTariffPlus(int subscriptionFee, int costMinuteInNW, int costMinuteInOtherNW,
                                    int costSms, int costInternet, int packageInternet, int packageMinute) {
        return new TariffPlus(subscriptionFee, costMinuteInNW, costMinuteInOtherNW,
                costSms, costInternet, Tariff.Species.MAXIMUM, packageInternet, packageMinute);
    }
}
