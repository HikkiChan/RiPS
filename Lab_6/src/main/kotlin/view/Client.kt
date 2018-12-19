package view

import model.TariffApiService
import model.entities.Customer
import model.entities.Tariff
import java.net.MalformedURLException
import java.rmi.Naming
import java.rmi.NotBoundException
import java.rmi.RemoteException


object Client {
    @JvmStatic
    fun main(args: Array<String>) {
        val serviceUrl = "//localhost:2020/TariffApiService"
        var service: TariffApiService? = null
        try {
            service = Naming.lookup(serviceUrl) as TariffApiService
        } catch (e: NotBoundException) {
            e.printStackTrace()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }

        println("Client is trying to get customers list")
        println("Tariffs list : ")
        val customersList: List<Customer>?
        try {
            customersList = service!!.getCustomers()
            println(customersList)
            println("Client successfully received customers list")
        } catch (e: RemoteException) {
            e.printStackTrace()
        }

        println("Client is trying to get tariffs list")
        println("Tariffs list : ")
        var tariffsList: List<Tariff>?
        try {
            tariffsList = service!!.getTariffs()
            println(tariffsList)
            println("Client successfully received tariffs list")
        } catch (e: RemoteException) {
            e.printStackTrace()
        }

        println("Client is trying to sort tariffs list by subscription fee")
        println("Tariffs list : ")
        try {
            service!!.sortBySubscriptionFee()
            tariffsList = service.getTariffs()
            println(tariffsList)
            println("Client successfully sorted tariffs list")
        } catch (e: RemoteException) {
            e.printStackTrace()
        }
    }
}