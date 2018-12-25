package util

import model.entities.TariffList
import java.io.File
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller

object JAXBParser {
    private var inputFileName: String = "DLC_3/input.xml"
    private var outputFileName: String = "DLC_3/output.xml"


    fun unmarshall(): TariffList {
        return JAXBContext.newInstance(TariffList::class.java).createUnmarshaller().unmarshal(File(inputFileName)) as TariffList
    }

    fun marshall(tariffs: TariffList) {
        val marshaller = JAXBContext.newInstance(TariffList::class.java).createMarshaller()

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        marshaller.marshal(tariffs, File(outputFileName))
    }
}



