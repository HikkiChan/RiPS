package net

import utils.AcceptException
import utils.ClientCreationException
import java.io.IOException
import java.io.PrintWriter
import java.net.ServerSocket
import java.util.*

class Server(port: Int) {
    private val serverSocket = initServerSocket(port)
    val clients = ArrayList<PrintWriter>()

    private fun initServerSocket(port: Int) = try {
        ServerSocket(port)
    } catch (e: IOException) {
        throw ClientCreationException("Error while initializing socket", e)
    }

    fun run() {
        println("Server is running")
        while (true) {
            try {
                Thread(ServerConnection(serverSocket.accept(), this, clients.size + 1)).start()
            } catch (e: IOException) {
                throw AcceptException("Error while accepting socket", e)
            }
        }
    }
}
