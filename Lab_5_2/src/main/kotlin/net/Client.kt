package net

import utils.ClientCreationException
import utils.ReadException
import utils.WriteException
import java.io.IOException
import java.net.InetAddress
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel
import java.util.*

private const val WRITE = "w"

class Client(port: Int) {

    private var socket = initAndConfigureSocket(port)

    private fun initAndConfigureSocket(port: Int) = try {
        SocketChannel.open(InetSocketAddress(InetAddress.getLocalHost(), port)).apply { configureBlocking(false) }
    } catch (e: IOException) {
        throw ClientCreationException("Error while connecting to the server", e)
    }

    fun run() {
        println("Client connects to the server")
        val buf = ByteBuffer.allocate(1024)
        readData(buf)
        val clientNumber = String(buf.array()).trim { it <= ' ' }.toInt()
        buf.clear()

        println("Users online: $clientNumber, you are user #$clientNumber")

        println("New client has connected\nSending message to new client about list of clients")
        println("Write c to wait for messages, w to send the message")
        val scanner = Scanner(System.`in`)
        scanner.nextLine().let {
            if (it == WRITE) {
                println("Enter the message:")
                val message = scanner.nextLine()
                println("Enter the recipient of your message:")
                var user = scanner.nextInt()

                while (user == clientNumber || user < 1 || user > clientNumber) {
                    println("Invalid recipient. Try to enter the recipient again")
                    user = scanner.nextInt()
                }
                println("Client sending messages to server...")

                with(buf) {
                    put(("$clientNumber~$user~$message").toByteArray())
                    flip()
                    writeData(this)
                    clear()
                }
            }
        }

        while (true) {
            println("Waiting for messages")
            while (true) {
                readData(buf)
                println(String(buf.array()).trim { it <= ' ' })
                buf.clear()
            }
        }
    }

    private fun readData(buffer: ByteBuffer) = try {
        while (socket.read(buffer) == 0) {

        }
    } catch (e: IOException) {
        throw ReadException("Error while reading data from the server", e)
    }

    private fun writeData(buffer: ByteBuffer) = try {
        socket.write(buffer)
    } catch (e: IOException) {
        throw WriteException("Error while writing message to the server", e)
    }
}