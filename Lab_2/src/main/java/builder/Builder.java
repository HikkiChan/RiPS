package builder;

import tariffs.TariffPlus;

public interface Builder {
    TariffPlus getTariffPlus(int subscriptionFee, int costMinuteInNW, int costMinuteInOtherNW,
                                    int costSms, int costInternet, int packageInternet, int packageMinute);
}