package model.entities

import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class TariffList(@XmlAttribute val name: String) {
    constructor() : this("Unnamed Library")

    @XmlElement
    val tariff: MutableCollection<Tariff> = mutableListOf()
}