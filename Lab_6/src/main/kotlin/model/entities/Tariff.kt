package model.entities

import java.io.Serializable

/**
 * @property species - type of mobile tariffs.
 * @property subscriptionFee - mobile tariff subscription fee.
 * @property costMinuteInNW - cost per minute in the mobile operator network.
 * @property costMinuteInOtherNW - cost per minute in the network of another mobile operator.
 * @property costSms - cost of one sms message.
 * @property costInternet - the cost of one megabyte of Internet traffic.
 */
data class Tariff(val name: String, val species: Species, val subscriptionFee: Int, val costMinuteInNW: Int,
                  val costMinuteInOtherNW: Int, val costSms: Int, val costInternet: Int) :
        Serializable {

    enum class Species { LITE, MAXIMUM, SMART }

    override fun toString() = "Tariff(name='$name', species=$species, subscription fee=$subscriptionFee, " +
            "cost minute in NW=$costMinuteInNW, cost minute in other NW=$costMinuteInOtherNW," +
            "cost Sms=$costSms, cost Internet=$costInternet)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Tariff) return false

        if (name != other.name) return false
        if (species != other.species) return false
        if (subscriptionFee != other.subscriptionFee) return false
        if (costMinuteInNW != other.costMinuteInNW) return false
        if (costMinuteInOtherNW != other.costMinuteInOtherNW) return false
        if (costSms != other.costSms) return false
        if (costInternet != other.costInternet) return false

        return true
    }


    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + species.hashCode()
        result = 31 * result + subscriptionFee
        result = 31 * result + costMinuteInNW
        result = 31 * result + costMinuteInOtherNW
        result = 31 * result + costSms
        result = 31 * result + costInternet
        return result
    }
}
