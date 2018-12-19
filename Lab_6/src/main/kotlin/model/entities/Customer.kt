package model.entities

import java.io.Serializable

/**
 * @property clientName - name of client.
 * @property clientNumber - client's mobile phone number.
 * @property species - type of mobile tariffs.
 */

data class Customer(val clientName: String, val species: Tariff.Species, val clientNumber: Int) :
        Serializable {

    override fun toString() = "Customer(client name='$clientName', species=$species, client number=$clientNumber)"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Customer) return false

        if (clientName != other.clientName) return false
        if (species != other.species) return false
        if (clientNumber != other.clientNumber) return false

        return true
    }


    override fun hashCode(): Int {
        var result = clientName.hashCode()
        result = 31 * result + species.hashCode()
        result = 31 * result + clientNumber
        return result
    }
}
