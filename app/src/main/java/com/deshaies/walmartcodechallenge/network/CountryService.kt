package com.deshaies.walmartcodechallenge.network

import com.deshaies.walmartcodechallenge.model.CountryListResponse
import retrofit2.Response
import retrofit2.http.GET

interface CountryService {

    @GET("countries.json")
    suspend fun getCountryList(): Response<CountryListResponse>
}