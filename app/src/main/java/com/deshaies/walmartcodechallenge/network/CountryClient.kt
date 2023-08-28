package com.deshaies.walmartcodechallenge.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CountryClient {

    fun create(): CountryService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(CountryService::class.java)
    }

    companion object {
        const val baseUrl = "https://gist.githubusercontent.com"
        const val endPoint =
            "/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/"
        const val BASE_URL = "${baseUrl}${endPoint}"
    }
}