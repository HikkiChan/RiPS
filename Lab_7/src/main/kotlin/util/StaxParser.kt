package util

import exceptions.ParsingException
import model.entities.Tariff
import java.io.FileNotFoundException
import java.io.FileReader
import java.util.*
import javax.xml.stream.XMLInputFactory
import javax.xml.stream.XMLStreamConstants
import javax.xml.stream.XMLStreamException


object StaxParser {

    private var isName = false
    private var isSpecies = false
    private var isSubscriptionFee = false
    private var isCostMinuteInNW = false
    private var isCostMinuteInOtherNW = false
    private var isCostSms = false
    private var isCostInternet = false
    private val data = StringBuilder()

    @Throws(ParsingException::class)
    fun parse(): List<Tariff> {
        println("Started parsing tariffs file")
        val tariffs = ArrayList<Tariff>()
        val factory = XMLInputFactory.newInstance()
        try {
            val eventReader = factory.createXMLEventReader(FileReader("lab_7/input.xml"))
            var builder: Tariff.Builder? = null

            while (eventReader.hasNext()) {
                val event = eventReader.nextEvent()
                when (event.eventType) {
                    XMLStreamConstants.START_ELEMENT -> {
                        val qName = event.asStartElement().name.localPart

                        when (qName) {
                            "tariff" -> {
                                if (builder != null) {
                                    tariffs.add(builder.build())
                                }
                                builder = Tariff.newBuilder()
                            }
                            "name" -> isName = true
                            "species" -> isSpecies = true
                            "subscription fee" -> isSubscriptionFee = true
                            "cost minute in NW" -> isCostMinuteInNW = true
                            "cost minute in other NW" -> isCostMinuteInOtherNW = true
                            "cost sms" -> isCostSms = true
                            "cost Internet" -> isCostInternet = true
                        }
                    }

                    XMLStreamConstants.CHARACTERS -> {
                        val characters = event.asCharacters()
                        data.setLength(0)
                        data.append(characters)
                    }

                    XMLStreamConstants.END_ELEMENT -> {
                        val endElement = event.asEndElement()

                        when {
                            isName -> {
                                builder!!.setName(data.toString())
                                isName = false
                            }
                            isSpecies -> {
                                builder!!.setSpecies(data.toString())
                                isSpecies = false
                            }
                            isSubscriptionFee -> {
                                builder!!.setSubscriptionFee(data.toString().toInt())
                                isSubscriptionFee = false
                            }
                            isCostMinuteInNW -> {
                                builder!!.setCostMinuteInNW(data.toString().toInt())
                                isCostMinuteInNW = false
                            }
                            isCostMinuteInOtherNW -> {
                                builder!!.setCostMinuteInOtherNW(data.toString().toInt())
                                isCostMinuteInOtherNW = false
                            }
                            isCostSms -> {
                                builder!!.setCostSms(data.toString().toInt())
                                isCostSms = false
                            }
                            isCostInternet -> {
                                builder!!.setCostInternet(data.toString().toInt())
                                isCostInternet = false
                            }
                        }

                        if (endElement.name.localPart == "tariffs") {
                            tariffs.add(builder!!.build())
                        }
                    }
                }
            }
        } catch (e: XMLStreamException) {
            throw ParsingException("Error has occurred while parsing file", e)
        } catch (e: FileNotFoundException) {
            throw ParsingException("Error has occurred while parsing file", e)
        }

        println("Finished parsing tariffs file")

        return tariffs
    }
}