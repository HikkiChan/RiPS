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

//(val name: String, val species: Species, val subscriptionFee: Int, val costMinuteInNW: Int,
//                  val costMinuteInOtherNW: Int, val costSms: Int, val costInternet: Int)

class Tariff: Serializable {

    companion object {
        fun newBuilder() = Tariff().Builder()
    }


    var name: String? = null
    var species: Species? = null
    var subscriptionFee: Int? = null
    var costMinuteInNW: Int? = null
    var costMinuteInOtherNW: Int? = null
    var costSms: Int? = null
    var costInternet: Int? = null

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
        result = 31 * result + subscriptionFee.hashCode()
        result = 31 * result + costMinuteInNW.hashCode()
        result = 31 * result + costMinuteInOtherNW.hashCode()
        result = 31 * result + costSms.hashCode()
        result = 31 * result + costInternet.hashCode()
        return result
    }


    inner class Builder {

        fun setName(name: String): Builder {
            this@Tariff.name = name
            return this
        }

        @Throws(IllegalArgumentException::class)
        fun setSpecies(species: String): Builder {
            this@Tariff.species = Species.valueOf(species)
            return this
        }

        @Throws(NumberFormatException::class)
        fun setSubscriptionFee(subscriptionFee: Int): Builder {
            if (subscriptionFee <= 0) {
                throw NumberFormatException()
            }
            this@Tariff.subscriptionFee = subscriptionFee
            return this
        }

        @Throws(NumberFormatException::class)
        fun setCostMinuteInNW(costMinuteInNW: Int): Builder {
            if (costMinuteInNW <= 0) {
                throw NumberFormatException()
            }
            this@Tariff.costMinuteInNW = costMinuteInNW
            return this
        }

        @Throws(NumberFormatException::class)
        fun setCostMinuteInOtherNW(costMinuteInOtherNW: Int): Builder {
            if (costMinuteInOtherNW <= 0) {
                throw NumberFormatException()
            }
            this@Tariff.costMinuteInOtherNW = costMinuteInOtherNW
            return this
        }

        @Throws(NumberFormatException::class)
        fun setCostSms(costSms: Int): Builder {
            if (costSms <= 0) {
                throw NumberFormatException()
            }
            this@Tariff.costSms = costSms
            return this
        }

        @Throws(NumberFormatException::class)
        fun setCostInternet(costInternet: Int): Builder {
            if (costInternet <= 0) {
                throw NumberFormatException()
            }
            this@Tariff.costInternet = costInternet
            return this
        }

        fun build() = this@Tariff
    }
}
