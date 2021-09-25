package com.example.currencyconverterapp.repos


import com.example.currencyconverterapp.utilities.Constants
import com.example.currencyconverterapp.models.response.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.*
import javax.inject.Inject

interface HomeApis {
    @GET(Constants.Endpoints.rates)
    suspend fun rates(): Response<RatesResponse>

}

interface HomeRepoInterface {
    suspend fun rates(): Response<RatesResponse>

}

class HomeRepo @Inject constructor(retrofit: Retrofit) : HomeRepoInterface {
    private val api = retrofit.create(HomeApis::class.java)
    override suspend fun rates(): Response<RatesResponse> {
        return api.rates()
    }


}