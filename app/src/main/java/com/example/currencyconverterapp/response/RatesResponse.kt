package com.example.currencyconverterapp.models.response


import com.example.currencyconverterapp.ui.viewitem.RatesViewItem
import com.example.currencyconverterapp.utilities.builders.recyclerview.AbstractViewItem
import com.example.currencyconverterapp.utilities.builders.recyclerview.ViewItemRepresentable

data class RatesResponse(
    val base: String,
    val rates: HashMap<String, Double>,
    val success: Boolean,
)

data class ExchangeRate(
    val country: String,
    val rate: Double
)

class RateView(
    rates: ExchangeRate
) : ViewItemRepresentable {
    override val viewItem: AbstractViewItem
        get() = RatesViewItem(
            this
        )
    var country = rates.country
    var rate = rates.rate
}