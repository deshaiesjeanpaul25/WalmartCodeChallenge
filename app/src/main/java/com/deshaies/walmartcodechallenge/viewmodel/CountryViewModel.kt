package com.deshaies.walmartcodechallenge.viewmodel

import androidx.lifecycle.*
import com.deshaies.walmartcodechallenge.network.CountryRepository
import kotlinx.coroutines.launch

class CountryViewModel (
    private val repository: CountryRepository
    ) : ViewModel() {

    private val _countryListLiveData = MutableLiveData<UIState>()
    val countryListLiveData: MutableLiveData<UIState> = _countryListLiveData

    fun fetchCountryList() {
        viewModelScope.launch {
            val response = repository.getCountryList()
            _countryListLiveData.value = response
        }
    }


}