package com.example.currencyconverterapp.utilities.builders.recyclerview

data class ViewItemsObserver(
    var viewItemsArrayList: ArrayList<AbstractViewItem> = arrayListOf(),
    var clearsOnSet: Boolean = false,
    var appendToEnd: Boolean = true
)