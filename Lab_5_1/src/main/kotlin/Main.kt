import net.Client
import net.Server
import utils.NetworkException
import java.util.*

object Lab5 {
    private const val SERVER = "s"
    private const val CLIENT = "c"
    private const val PORT_NUMBER = 9001

    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        println("write s to run server, c to run client")
        scanner.nextLine().let {
            if (it == SERVER) {
                runServer()
            } else if (it == CLIENT) {
                runClient()
            }
        }
    }

    private fun runServer() = try {
        Server(PORT_NUMBER).run()
    } catch (e: NetworkException) {
        e.printStackTrace()
    }

    private fun runClient() = try {
        Client(PORT_NUMBER).run()
    } catch (e: NetworkException) {
        e.printStackTrace()
    }
}
