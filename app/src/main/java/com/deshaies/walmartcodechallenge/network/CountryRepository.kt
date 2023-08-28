package com.deshaies.walmartcodechallenge.network

import com.deshaies.walmartcodechallenge.viewmodel.UIState

class CountryRepository(private val service: CountryService) {
    suspend fun getCountryList(): UIState {
        val response =  service.getCountryList()
        if (response.isSuccessful) {
            return response.body()?.let {
                UIState.Success(it)
            } ?: UIState.Failure(response.message())
        } else {
            return UIState.Failure(response.message())
        }
    }
}
