package net

import utils.ServerCreationException
import utils.initInput
import utils.initOutput
import java.io.BufferedReader
import java.io.IOException
import java.io.PrintWriter
import java.net.Socket

class ServerConnection(socket: Socket, private val server: Server, private val clientNumber: Int) : Runnable {
    private val `in`: BufferedReader
    private val `out`: PrintWriter

    init {
        try {
            `in` = socket.initInput()
            `out` = socket.initOutput()
            synchronized(server.clients) {
                server.clients.add(`out`)
            }
        } catch (e: IOException) {
            throw ServerCreationException("Error while creating server", e)
        }
    }

    override fun equals(other: Any?) = if (other!!.javaClass == ServerConnection::class.java) {
        (other as ServerConnection).clientNumber == clientNumber
    } else false

    override fun hashCode() = clientNumber

    override fun run() {
        println("New client has connected\nSending message to new client about list of clients")
        synchronized(server.clients) {
            `out`.println(server.clients.size.toString() + ":" + clientNumber)
        }

        try {
            `in`.readLine().split("~".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray().let {
                (it[0].toInt() - 1).let { recipientNumber ->
                    println("Trying send message...")

                    if (recipientNumber <= server.clients.size) {
                        synchronized(server.clients) {
                            server.clients[recipientNumber].println("Message from client #$clientNumber, message text: ${it[1]}")
                        }
                        println("Server transferring message from #$clientNumber to #${recipientNumber + 1}, message text: ${it[1]}")
                    } else {
                        synchronized(server.clients) {
                            server.clients[clientNumber - 1].println("Error. Client #${recipientNumber + 1}  not found.")
                        }
                        println("Error. Client #${recipientNumber + 1}  not found.")
                    }

                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}
