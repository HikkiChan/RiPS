package model

import model.entities.Tariff
import model.entities.Customer
import model.util.sortBySubscriptionFee
import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject

class TariffApi : UnicastRemoteObject, TariffApiService {

    private val tariffss by lazy { fetchTariffs() }

    private val customerss by lazy { fetchCustomers() }

    @Throws(RemoteException::class)
    constructor() : super()

    private fun fetchTariffs() = arrayListOf(
            Tariff("Tariff1", Tariff.Species.LITE, 25,
                    25, 25, 25,25),
            Tariff("Tariff2", Tariff.Species.SMART, 1200,
                    15, 15, 15,15),
            Tariff("Tariff3", Tariff.Species.MAXIMUM, 100,
                    10, 10, 10,10)
    )

    private fun fetchCustomers() = arrayListOf(
            Customer("Customer1", Tariff.Species.LITE, 4655626),
            Customer("Customer2", Tariff.Species.SMART, 1234567),
            Customer("Customer3", Tariff.Species.MAXIMUM, 7654321)
    )

    @Synchronized
    override fun getTariffs() = tariffss

    @Synchronized
    override fun getCustomers() = customerss

    @Synchronized
    override fun sortBySubscriptionFee() = tariffss.sortBySubscriptionFee()
}