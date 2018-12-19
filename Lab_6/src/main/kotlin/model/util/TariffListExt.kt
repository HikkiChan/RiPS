package model.util

import model.entities.Tariff

fun MutableList<Tariff>.sortBySubscriptionFee() = sortBy { it.subscriptionFee }