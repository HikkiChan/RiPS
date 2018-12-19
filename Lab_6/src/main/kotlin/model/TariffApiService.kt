package model

import model.entities.Customer
import model.entities.Tariff
import java.rmi.Remote
import java.rmi.RemoteException

interface TariffApiService : Remote {

    @Throws(RemoteException::class)
    fun getTariffs(): List<Tariff>

    @Throws(RemoteException::class)
    fun getCustomers(): List<Customer>

    @Throws(RemoteException::class)
    fun sortBySubscriptionFee()
}