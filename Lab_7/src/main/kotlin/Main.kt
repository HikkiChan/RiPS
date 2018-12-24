import exceptions.*
import model.entities.Tariff
import util.*
import java.io.File
//import javax.xml.bind.ValidationException
import javax.xml.transform.stream.StreamSource
import javax.xml.validation.Schema
import javax.xml.validation.SchemaFactory

object Lab7 {
    @JvmStatic
    fun main(args: Array<String>) {
        validateXML()
        try {
            println(createTariffList())
        } catch (e: ParsingException) {
            e.printStackTrace()
        }
    }

    @Throws(ParsingException::class)
    fun createTariffList(): List<Tariff> {
//        return StaxParser.parse()
//        return DomParser.parse()
        return SaxParser.parse()
    }

    @Throws(ValidationException::class)
    fun validateXML() {
        val scFact = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema")
        val f = File("lab_7/schema.xsd")
        val schema: Schema?
        try {
            schema = scFact.newSchema(f)
            schema!!.newValidator().validate(StreamSource("lab_7/input.xml"))
            println("Validation completed successfully")
        } catch (e: Exception) {
            throw ValidationException("Error has occurred while validating xml", e)
        }
    }
}