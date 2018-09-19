import tariffs.Tariff;
import tariffs.TariffPlus;

import java.util.Comparator;

public class SortSpecies implements Comparator<Tariff> {
    @Override
    public int compare(Tariff o1, Tariff o2) {
        TariffPlus tariffPlus1 = new TariffPlus();
        TariffPlus tariffPlus2 = new TariffPlus();

        if (o1 instanceof TariffPlus) {
            tariffPlus1 = (TariffPlus) o1;
        }

        if (o2 instanceof TariffPlus) {
            tariffPlus2 = (TariffPlus) o2;
        }

        return tariffPlus1.getSpecies().compareTo(tariffPlus2.getSpecies());
    }
}
