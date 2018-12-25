import model.entities.TariffList
import util.JAXBParser

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val tariffs: TariffList = JAXBParser.unmarshall()

        println(tariffs.name)
        println(tariffs.tariff.size)
        println(tariffs.tariff.last())

        JAXBParser.marshall(tariffs)
    }

}