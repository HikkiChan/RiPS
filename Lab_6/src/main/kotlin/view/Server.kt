package view

import model.TariffApi
import model.TariffApiService
import java.net.MalformedURLException
import java.rmi.Naming
import java.rmi.RemoteException
import java.rmi.registry.LocateRegistry

object Server {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Server started working")
        println("Initializing tariff api...")
        var api: TariffApiService? = null
        try {
            api = TariffApi()
        } catch (e: RemoteException) {
            e.printStackTrace()
        }

        LocateRegistry.createRegistry(2020)

        val serviceUrl = "//localhost:2020/TariffApiService"
        try {
            Naming.rebind(serviceUrl, api)
        } catch (e: RemoteException) {
            e.printStackTrace()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }

    }
}