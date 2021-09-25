package com.example.currencyconverterapp.ui.viewitem


import com.example.currencyconverterapp.R
import com.example.currencyconverterapp.databinding.ItemRatesBinding
import com.example.currencyconverterapp.models.response.RateView
import com.example.currencyconverterapp.utilities.builders.recyclerview.BindingViewItem
import javax.inject.Inject


class RatesViewItem @Inject constructor(
    private val setRatesView: RateView,
) : BindingViewItem<ItemRatesBinding>(
    R.layout.item_rates,
    setRatesView
) {
    override fun bind(binding: ItemRatesBinding, viewItemPosition: Int) {
        binding.rates = setRatesView
    }
}