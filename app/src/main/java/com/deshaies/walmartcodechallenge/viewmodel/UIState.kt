package com.deshaies.walmartcodechallenge.viewmodel

import com.deshaies.walmartcodechallenge.model.CountryListResponse

sealed class UIState {
    data class Success(val data: CountryListResponse): UIState()
    data class Failure(val error: String): UIState()
    data class Loading(val isLoading: Boolean): UIState()
}
