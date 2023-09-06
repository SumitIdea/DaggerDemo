package com.sumit.daggerdemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sumit.daggerdemo.api.CryptocurrencyRepository
import com.sumit.daggerdemo.model.Cryptocurrency
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
 class MainViewModel @Inject constructor(
    private val cryptocurrencyRepository: CryptocurrencyRepository, application: Application
) : AndroidViewModel(application)
{
    val cryptocurrencyEmitter = MutableLiveData<List<Cryptocurrency>>()
    init {
        loadCryptocurrency()
    }

      fun loadCryptocurrency(){
        cryptocurrencyEmitter.value = cryptocurrencyRepository.getCryptoCurrency()

    }
}

