package util

import exceptions.ParsingException
import model.entities.Tariff
import org.xml.sax.InputSource
import org.xml.sax.SAXException
import org.xml.sax.helpers.XMLReaderFactory
import java.io.IOException

object SaxParser {

    @Throws(ParsingException::class)
    fun parse(): List<Tariff> {
        println("Started parsing tariff file")
        val result: List<Tariff>
        try {
            val reader = XMLReaderFactory.createXMLReader()
            val myHandler = TariffContentHandler()
            reader.contentHandler = myHandler
            val inputSource = InputSource("lab_7/input.xml")
            try {
                reader.parse(inputSource)
                result = myHandler.getVoucherList()!!
            } catch (e: IOException) {
                throw ParsingException("Error has occurred while parsing doc", e)
            }

        } catch (e: SAXException) {
            throw ParsingException("Error has occurred while creating XMLReaderFactory", e)
        }

        println("Finished parsing tariff file")
        return result
    }
}