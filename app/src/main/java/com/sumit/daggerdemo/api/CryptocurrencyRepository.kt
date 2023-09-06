package com.sumit.daggerdemo.api

import com.sumit.daggerdemo.model.Cryptocurrency

interface CryptocurrencyRepository {
    fun getCryptoCurrency(): List<Cryptocurrency>

}