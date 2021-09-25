package com.example.currencyconverterapp.ui.viewmodel

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyconverterapp.R
import com.example.currencyconverterapp.models.response.ExchangeRate
import com.example.currencyconverterapp.models.response.Message
import com.example.currencyconverterapp.models.response.RateView
import com.example.currencyconverterapp.repos.HomeRepoInterface
import com.example.currencyconverterapp.utilities.ViewState
import com.example.currencyconverterapp.utilities.managers.ApiRequestManagerInterface
import com.example.currencyconverterapp.utilities.managers.InternetConnectionManagerInterface
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val internetConnectionManager: InternetConnectionManagerInterface,
    private val apiRequestManager: ApiRequestManagerInterface,
    private val homeRepoInterface: HomeRepoInterface,
    private val resources: Resources,
) : ViewModel() {
    var rateViews = MutableLiveData<ViewState<List<RateView>>>()
    val exchangeRates = ArrayList<ExchangeRate>()

    fun getRates() {
        if (internetConnectionManager.isConnectedToInternet) {
            rateViews.value = ViewState.Loading

            apiRequestManager.execute(
                request = {
                    homeRepoInterface.rates()
                },
                onSuccess = { data, headers, statusCode ->
                    if (data.success){
                        exchangeRates.addAll(
                            data.rates.toSortedMap().map { ExchangeRate(it.key, it.value) })
                        rateViews.value = ViewState.Success(exchangeRates.map {
                            RateView(it)
                        })
                    }
                },
                onFailure = { message, statusCode ->
                    rateViews.value = ViewState.Error(message)
                }
            )

        } else {
            rateViews.value =
                ViewState.Error(
                    Message(
                        resources.getString(
                            R.string.no_internet_connection
                        )
                    )
                )
        }
    }


}