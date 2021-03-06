import builder.SearchEngine;
import builder.TariffPlusBuilder;
import client.Client;
import tariffs.Tariff;
import tariffs.TariffPlus;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TariffPlus lite = TariffPlusBuilder.getTariffPlus(25, 25, 25,
                25, 25, Tariff.Species.LITE, 512, 60);
        TariffPlus smart = TariffPlusBuilder.getTariffPlus(50, 15, 15,
                15, 15, Tariff.Species.SMART, 1024, 120);
        TariffPlus maximum = TariffPlusBuilder.getTariffPlus(100, 10, 10,
                10, 10, Tariff.Species.MAXIMUM, 2048, 180);

        List<Tariff> listTariffs = new ArrayList<>();
        List<Client> listClients = new ArrayList<>();

        listTariffs.add(smart);
        listTariffs.add(lite);
        listTariffs.add(maximum);

        Client client1 = new Client("Anton", "80444656556", Tariff.Species.SMART);
        Client client2 = new Client("Qwerty", "80141388379", Tariff.Species.MAXIMUM);
        Client client3 = new Client("Anon", "80123456789", Tariff.Species.LITE);

        listClients.add(client1);
        listClients.add(client2);
        listClients.add(client3);

        listTariffs.sort(new TariffComparator());

        System.out.println(SearchEngine.searchTariffForCostMinuteInNW(listTariffs, 10));
        System.out.println("Number  clients = " + listClients.size());
        for (Tariff tariffBonus : listTariffs) {
            System.out.println(tariffBonus);
        }
        for (Client client : listClients) {
            System.out.println(client);
        }
    }
}
