package com.example.currencyconverterapp.models.response

import com.google.gson.annotations.SerializedName

data class Message(@SerializedName("error") var errorMessage: String = "", var statusCode: Int = 0)