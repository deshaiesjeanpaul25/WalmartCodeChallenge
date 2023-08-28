package com.deshaies.walmartcodechallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.deshaies.walmartcodechallenge.adapter.CountryAdapter
import com.deshaies.walmartcodechallenge.databinding.ActivityMainBinding
import com.deshaies.walmartcodechallenge.network.CountryClient
import com.deshaies.walmartcodechallenge.network.CountryRepository
import com.deshaies.walmartcodechallenge.network.CountryService
import com.deshaies.walmartcodechallenge.viewmodel.CountryViewModel
import com.deshaies.walmartcodechallenge.viewmodel.UIState
import com.deshaies.walmartcodechallenge.viewmodel.provider.CountryProvider

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var countryAdapter: CountryAdapter

    private val service: CountryService by lazy {
        CountryClient().create()
    }
    private val repository: CountryRepository by lazy {
        CountryRepository(service)
    }
    private val countryViewModel: CountryViewModel by lazy {
        ViewModelProvider(this, CountryProvider(repository))[CountryViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        countryAdapter = CountryAdapter()

        countryViewModel.countryListLiveData.observe(this) { countries ->
            when (countries) {
                is UIState.Failure -> {}
                is UIState.Success -> {
                    Log.d(TAG, "onCreate: Success")
                    countryAdapter.updateData(countries.data)
                }
                is UIState.Loading -> {}
            }
        }
        setupUI()
        countryViewModel.fetchCountryList()
    }

    private fun setupUI() {
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = countryAdapter
        }
    }
}