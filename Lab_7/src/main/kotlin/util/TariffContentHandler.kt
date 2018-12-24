package util

import model.entities.Tariff
import org.xml.sax.Attributes
import org.xml.sax.SAXException
import org.xml.sax.helpers.DefaultHandler
import java.util.*

class TariffContentHandler : DefaultHandler() {
    private var tariffList: MutableList<Tariff>? = null
    private var builder: Tariff.Builder? = null

    private var isName = false
    private var isSpecies = false
    private var isSubscriptionFee = false
    private var isCostMinuteInNW = false
    private var isCostMinuteInOtherNW = false
    private var isCostSms = false
    private var isCostInternet = false
    private val data = StringBuilder()

    @Throws(SAXException::class)
    override fun startElement(uri: String, localName: String, qName: String, attributes: Attributes) {
        if (qName == "tariff") {
            if (builder != null) {
                tariffList!!.add(builder!!.build())
            }
            builder = Tariff.newBuilder()
            if (tariffList == null)
                tariffList = ArrayList()
        } else if (qName == "name") {
            isName = true
        } else if (qName == "species") {
            isSpecies = true
        } else if (qName == "subscription fee") {
            isSubscriptionFee = true
        } else if (qName == "cost minute in NW") {
            isCostMinuteInNW = true
        } else if (qName == "cost minute in other NW") {
            isCostMinuteInOtherNW = true
        } else if (qName == "cost sms") {
            isCostSms = true
        } else if (qName == "cost Internet") {
            isCostInternet = true
        }
    }

    @Throws(SAXException::class)
    override fun characters(ch: CharArray, start: Int, length: Int) {
        data.setLength(0)
        data.append(String(ch, start, length))
    }

    @Throws(SAXException::class)
    override fun endElement(uri: String, localName: String, qName: String) {
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

        if (qName == "tariffs") {
            tariffList!!.add(builder!!.build())
        }
    }

    fun getVoucherList(): List<Tariff>? {
        return tariffList
    }
}