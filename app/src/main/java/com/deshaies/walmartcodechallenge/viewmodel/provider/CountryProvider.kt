package com.deshaies.walmartcodechallenge.viewmodel.provider

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deshaies.walmartcodechallenge.network.CountryRepository
import com.deshaies.walmartcodechallenge.viewmodel.CountryViewModel

class CountryProvider(private val repository: CountryRepository):
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CountryViewModel(repository) as T
    }
}