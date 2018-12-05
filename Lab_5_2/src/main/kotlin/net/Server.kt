package net

import utils.*
import java.io.IOException
import java.net.InetAddress
import java.net.InetSocketAddress
import java.nio.ByteBuffer
import java.nio.channels.SelectionKey
import java.nio.channels.Selector
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel
import java.util.*

class Server(port: Int) {

    private var socketChannel = initAndConfigureSocketChannel(port)
    private var selector = initAndConfigureSelector()
    private val clients = ArrayList<SocketChannel>()

    private fun initAndConfigureSocketChannel(port: Int) = try {
        ServerSocketChannel.open().apply {
            configureBlocking(false)
            socket().bind(InetSocketAddress(InetAddress.getLocalHost(), port))
        }
    } catch (e: IOException) {
        throw ServerCreationException("Error while configuring server socket channel", e)
    }

    private fun initAndConfigureSelector() = try {
        Selector.open().apply {
            socketChannel.register(this, socketChannel!!.validOps(), null)
        }
    } catch (e: IOException) {
        throw ServerCreationException("Can not configure socket", e)
    }

    private fun acceptClient() {
        println("New client is registering on server...")

        try {
            val client = socketChannel.accept().apply {
                configureBlocking(false)
                register(selector, SelectionKey.OP_READ)
                clients.add(this)
            }

            println("Registration of new client is finished.")
            println("Sending message to new client about list of clients")

            with(ByteBuffer.allocate(1024)) {
                put(clients.size.toString().toByteArray())
                flip()
                client.write(this)
            }
        } catch (e: IOException) {
            throw ClientRegistrationException("Error were occurred while client registration", e)
        }
    }

    private fun readAndTransferMessage(key: SelectionKey) {
        val buffer = ByteBuffer.allocate(1024)
        readMessage(key, buffer)

        val transf = String(buffer.array()).trim { it <= ' ' }
        if (transf.isNotEmpty()) {
            val str = transf.split("~".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val clientNumber = str[0].toInt() - 1
            val recipientNumber = str[1].toInt() - 1

            println("Server transferring message from #${clientNumber + 1} to #${recipientNumber + 1}, message text: ${str[2]}")
            with(buffer) {
                clear()
                put(("Message from client #${clientNumber + 1}, message text: ${str[2]}").toByteArray())
                flip()
                writeMessage(recipientNumber, buffer)
                clear()
            }
        }
    }

    private fun readMessage(key: SelectionKey, buffer: ByteBuffer) = try {
        (key.channel() as SocketChannel).read(buffer)
    } catch (e: IOException) {
        throw ReadException("Error were occurred while reading data from client", e)
    }

    private fun writeMessage(recipientNumber: Int, buffer: ByteBuffer) = try {
        clients[recipientNumber].write(buffer)
    } catch (e: IOException) {
        throw WriteException("Error were occurred while writing to client", e)
    }

    fun run() {
        println("Server is running")
        while (true) {
            select()
            selector.selectedKeys().iterator().let {
                while (it.hasNext()) {
                    processSelectionKey(it.next())
                    it.remove()
                }
            }
        }
    }

    private fun select() = try {
        selector.select()
    } catch (e: IOException) {
        throw SelectorException("Error while trying to select", e)
    }

    private fun processSelectionKey(currentKey: SelectionKey) = when {
        currentKey.isAcceptable -> acceptClient()
        currentKey.isReadable -> readAndTransferMessage(currentKey)
        else -> {}
    }
}