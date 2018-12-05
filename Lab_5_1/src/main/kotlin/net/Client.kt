package net

import utils.ClientCreationException
import utils.ReadException
import utils.initInput
import utils.initOutput
import java.io.BufferedReader
import java.io.IOException
import java.io.PrintWriter
import java.net.InetAddress
import java.net.Socket
import java.nio.ByteBuffer
import java.util.*

private const val WRITE = "w"

class Client(port: Int) {

    companion object {
        private const val BUFFER_CAPACITY = 48
    }

    private val `in`: BufferedReader
    private val `out`: PrintWriter

    init {
        val socket = initSocket(port)
        `in` = socket.initInput()
        `out` = socket.initOutput()
    }

    private fun initSocket(port: Int) = try {
        Socket(InetAddress.getLocalHost(), port)
    } catch (e: IOException) {
        throw ClientCreationException("Error while initializing socket", e)
    }

    fun run() {
        println("Client is waiting for the list of users...")

        val buf = ByteBuffer.allocate(BUFFER_CAPACITY)
        val usersInfo = getUsersInfo()
        buf.clear()

        println("Users online: ${usersInfo[0]}, you are user #${usersInfo[1]}")

        val scanner = Scanner(System.`in`)

        println("Write c to wait for messages, w to send the message")
        scanner.nextLine().let {
            if (it == WRITE) {
                with(Scanner(System.`in`)) {
                    println("Enter the message:")
                    val message = nextLine()

                    println("Enter the recipient of your message:")
                    var recipientNumber = nextInt()

                    while (recipientNumber == usersInfo[0].toInt() || recipientNumber < 1) {
                        println("Invalid recipient. Try to enter the recipient again")
                        recipientNumber = nextInt()
                    }

                    println("Client sending messages to server...")
                    `out`.println("$recipientNumber~$message")
                }

            }
        }

        buf.clear()

        waitForMessages()
    }

    private fun getUsersInfo() = try {
        `in`.readLine().split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    } catch (e: IOException) {
        throw ReadException("Error while reading input", e)
    }

    private fun waitForMessages() {
        while (true) {
            println("Waiting for messages")
            try {
                println(`in`.readLine())
            } catch (e: IOException) {
                throw ReadException("Error while reading input", e)
            }
        }
    }
}