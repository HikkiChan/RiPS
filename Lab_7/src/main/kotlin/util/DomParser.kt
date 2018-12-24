package util

import exceptions.ParsingException
import model.entities.Tariff
import org.w3c.dom.Element
import org.xml.sax.SAXException
import java.io.File
import java.io.IOException
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException

object DomParser {

    @Throws(ParsingException::class)
    fun parse(): List<Tariff> {
        println("Started parsing tariff file")
        val res = ArrayList<Tariff>()
        val factory = DocumentBuilderFactory.newInstance()
        val inputFile = File("lab_7/input.xml")

        try {
            val builder = factory.newDocumentBuilder()
            val doc = builder.parse(inputFile)
            doc.documentElement.normalize()
            val nList = doc.getElementsByTagName("tariff")

            for (i in 0 until nList.length) {
                val eElement = nList.item(i) as Element

                val tariffBuilder = Tariff.newBuilder()
                tariffBuilder.setName(
                        eElement.getElementsByTagName("name")
                                .item(0)
                                .textContent
                )

                tariffBuilder.setSpecies(
                        eElement.getElementsByTagName("species")
                                .item(0)
                                .textContent
                )

                tariffBuilder.setSubscriptionFee(
                        eElement.getElementsByTagName("subscriptionFee")
                                .item(0)
                                .textContent
                                .toInt()
                )

                tariffBuilder.setCostMinuteInNW(
                        eElement.getElementsByTagName("costMinuteInNW")
                                .item(0)
                                .textContent
                                .toInt()
                )

                tariffBuilder.setCostMinuteInOtherNW(
                        eElement.getElementsByTagName("costMinuteInOtherNW")
                                .item(0)
                                .textContent
                                .toInt()
                )

                tariffBuilder.setCostSms(
                        eElement.getElementsByTagName("costSms")
                                .item(0)
                                .textContent
                                .toInt()
                )

                tariffBuilder.setCostInternet(
                        eElement.getElementsByTagName("costInternet")
                                .item(0)
                                .textContent
                                .toInt()
                )

                res.add(tariffBuilder.build())
            }
        } catch (e: SAXException) {
            throw ParsingException("Error has occurred while creating document builder", e)
        } catch (e: IOException) {
            throw ParsingException("Error has occurred while creating document builder", e)
        } catch (e: ParserConfigurationException) {
            throw ParsingException("Error has occurred while creating document builder", e)
        }

        return res
    }
}