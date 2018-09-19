package builder;

import tariffs.Tariff;
import tariffs.TariffPlus;

import java.util.List;

public class Worker {
    public static Tariff searchTariffForCostMinuteInNW(List<Tariff> tariff, int costMinuteInNW) {
        TariffPlus tariffPlus = new TariffPlus();

        for (Tariff i: tariff) {
            if (i instanceof TariffPlus) {
                tariffPlus = (TariffPlus) i;
                if (tariffPlus.getCostMinuteInNW() == costMinuteInNW) {
                    return tariffPlus;
                }
            }
        }

        return tariffPlus;
    }
}
