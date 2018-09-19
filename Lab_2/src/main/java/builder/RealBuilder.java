package builder;

import tariffs.Tariff;
import tariffs.TariffPlus;

public class RealBuilder {
    public static TariffPlus getTariffPlus(int subscriptionFee, int costMinuteInNW, int costMinuteInOtherNW,
                                            int costSms, int costInternet, Tariff.Species species,
                                            int packageInternet, int packageMinute) {
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
