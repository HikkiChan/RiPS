import java.io.FileNotFoundException
import java.io.FileOutputStream
import javax.xml.transform.TransformerConfigurationException
import javax.xml.transform.TransformerException
import javax.xml.transform.TransformerFactory
import javax.xml.transform.TransformerFactoryConfigurationError
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        /*val tariffs: TariffList = JAXBParser.unmarshall()

        println(tariffs.name)
        println(tariffs.tariff.size)
        println(tariffs.tariff.last())

        JAXBParser.marshall(tariffs)*/

        try {
            val tFactory = TransformerFactory.newInstance()
            val xslDoc = StreamSource("DLC_4_1/tariffList.xsl")
            val xmlDoc = StreamSource("DLC_4_1/input.xml")

            val outputFileName = "DLC_4_1/TariffList.html"

            val htmlFile = FileOutputStream(outputFileName)
            val trasform = tFactory.newTransformer(xslDoc)
            trasform.transform(xmlDoc, StreamResult(htmlFile))

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: TransformerConfigurationException) {
            e.printStackTrace()
        } catch (e: TransformerFactoryConfigurationError) {
            e.printStackTrace()
        } catch (e: TransformerException) {
            e.printStackTrace()
        }
    }

}